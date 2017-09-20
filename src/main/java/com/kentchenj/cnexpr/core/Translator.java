package com.kentchenj.cnexpr.core;

import com.kentchenj.cnexpr.CnExprException;
import com.kentchenj.cnexpr.Factor;
import com.kentchenj.cnexpr.parser.CnExprBaseVisitor;
import com.kentchenj.cnexpr.parser.CnExprLexer;
import com.kentchenj.cnexpr.parser.CnExprParser;
import com.kentchenj.cnexpr.type.DateType;
import com.kentchenj.cnexpr.type.DatetimeType;
import com.kentchenj.cnexpr.type.Type;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 翻译器
 *
 * @author Kent Chen
 */
public class Translator extends CnExprBaseVisitor {
  private Map<String, Factor> factorMap;
  private StringBuilder destScript = new StringBuilder();
  private Stack<Factor> dateTypeStack = new Stack<>();

  /**
   * 根据FactorDef生成日期函数调用字符串
   *
   * @param factor
   * @param isDatetime
   * @return
   */
  private String generateDateString(Factor factor, boolean isDatetime) {
    StringBuilder sb = new StringBuilder(" DateUtils.dateToJodaTime(");
    sb.append(factor.getCode());
    sb.append(")");
    if (!isDatetime) {
      sb.append(".toLocalDate()");
    }
    return sb.toString();
  }

  /**
   * 根据字符串生成日期函数调用字符串
   *
   * @param str
   * @param formatter
   * @param isDateTime
   * @return
   */
  private String generateDateString(String str, String formatter, boolean isDateTime) {
    StringBuilder sb = new StringBuilder(" DateUtils.stringToJodaTime(");
    sb.append(str);
    sb.append(",\"");
    sb.append(formatter);
    sb.append("\")");
    if (!isDateTime) {
      sb.append(".toLocalDate()");
    }
    return sb.toString();
  }

  /**
   * 生成日期表达式字符串
   *
   * @param leftFactor
   * @param rightFactor
   * @param op
   * @param leftExpr
   * @param rightExpr
   * @return
   */
  private String generateDateExprStr(Factor leftFactor, Factor rightFactor, String op, String leftExpr, String rightExpr) {
    boolean isDatetimeType = false;
    if (leftFactor != null && rightFactor == null) { //只有左边是日期型
      DateType leftDateType = getDateType(leftFactor);
      if (leftDateType instanceof DatetimeType) isDatetimeType = true;
      return generateDateString(leftFactor, isDatetimeType) + " " + op + " " + generateDateString(rightExpr, leftDateType.getFormatter(), isDatetimeType);
    } else if (leftFactor == null && rightFactor != null) { //只有右边是日期型
      DateType rightDateType = getDateType(rightFactor);
      if (rightDateType instanceof DatetimeType) isDatetimeType = true;
      return generateDateString(leftExpr, rightDateType.getFormatter(), isDatetimeType) + " " + op + " " + generateDateString(rightFactor, isDatetimeType);
    } else if (leftFactor != null) { //两边都是日期型，如果两者都是DateTime型，按DateTime比较，否则，按Date比较
      DateType leftDateType = getDateType(leftFactor);
      DateType rightDateType = getDateType(rightFactor);
      isDatetimeType = leftDateType instanceof DatetimeType && rightDateType instanceof DatetimeType;
      return generateDateString(leftFactor, isDatetimeType) + " " + op + " " + generateDateString(rightFactor, isDatetimeType);
    } else {
      return leftExpr + " " + op + " " + rightExpr;
    }
  }

  public Translator(Map<String, Factor> factorMap) {
    this.factorMap = factorMap;
  }

  public String translate(String expr) {
    CnExprLexer lexer = new CnExprLexer(CharStreams.fromString(expr));
    CnExprParser parser = new CnExprParser(new CommonTokenStream(lexer));
    ParseTree tree = parser.cnExpr();
    visit(tree);
    return destScript.toString();
  }

  /**
   * 获得Factor的DateType，如果不是日期型，返回null
   *
   * @param factor
   * @return DateType
   */
  private DateType getDateType(Factor factor) {
    Type type = factor.getType();
    return type instanceof DateType ? (DateType) type : null;
  }


  @Override
  public Object visitCnExpr(CnExprParser.CnExprContext ctx) {
    String exprBody = (String) visit(ctx.expression());
    this.destScript.append(exprBody);
    return this.destScript;
  }

  @Override
  public Object visitParens(CnExprParser.ParensContext ctx) {
    return "(" + visit(ctx.expression()) + ")";
  }

  @Override
  public Object visitConstant(CnExprParser.ConstantContext ctx) {
    return ctx.getText();
  }

  @Override
  public Object visitOr(CnExprParser.OrContext ctx) {
    return visit(ctx.expression(0)) + " " + ctx.op.getText() + " " + visit(ctx.expression(1));
  }

  @Override
  public Object visitIn(CnExprParser.InContext ctx) {
    if (ctx.Identifier() != null) {
      Factor factor = factorMap.get(ctx.Identifier().getText());
      return visit(ctx.expression()) + " in " + factor.getCode();
    } else if (ctx.literalArray() != null) {
      return visit(ctx.expression()) + " in " + visit(ctx.literalArray());
    } else if (ctx.stringOrIdentifierArray() != null) {
      return visit(ctx.expression()) + " in " + visit(ctx.stringOrIdentifierArray());
    } else if (ctx.decimalOrIdentifierArray() != null) {
      return visit(ctx.expression()) + " in " + visit(ctx.decimalOrIdentifierArray()) + ".flatten()";
    }
    throw new CnExprException("in expression error: $ctx.expression()");
  }

  @Override
  public Object visitAddSub(CnExprParser.AddSubContext ctx) {
    return visit(ctx.expression(0)) + " " + ctx.op.getText() + " " + visit(ctx.expression(1));
  }

  @Override
  public Object visitMatches(CnExprParser.MatchesContext ctx) {
    return visit(ctx.expression(0)) + " ==~ " + visit(ctx.expression(1));
  }

  @Override
  public Object visitMulDiv(CnExprParser.MulDivContext ctx) {
    return visit(ctx.expression(0)) + " " + ctx.op.getText() + " " + visit(ctx.expression(1));
  }

  @Override
  public Object visitNot(CnExprParser.NotContext ctx) {
    return "!(" + visit(ctx.expression()) + ")";
  }

  @Override
  public Object visitContains(CnExprParser.ContainsContext ctx) {
    return visit(ctx.expression(0)) + ".contains( " + visit(ctx.expression(1)) + ")";
  }

  @Override
  public Object visitGreatLess(CnExprParser.GreatLessContext ctx) {
    //如果有日期型，需要先处理
    Factor leftFactor = null;
    Factor rightFactor = null;
    String op = ctx.op.getText();

    //运算符左边是否日期型
    String leftExpr = (String) visit(ctx.expression(0));
    if (!this.dateTypeStack.empty()) {
      leftFactor = this.dateTypeStack.pop();
    }

    //运算符右边是否日期型
    String rightExpr = (String) visit(ctx.expression(1));
    if (!this.dateTypeStack.empty()) {
      rightFactor = this.dateTypeStack.pop();
    }

    return generateDateExprStr(leftFactor, rightFactor, op, leftExpr, rightExpr);

  }

  @Override
  public Object visitEqualUnequal(CnExprParser.EqualUnequalContext ctx) {
    String op = ctx.op.getText();
    Factor leftFactor = null;
    Factor rightFactor = null;


    String leftExpr = (String) visit(ctx.expression(0));
    if (!this.dateTypeStack.empty()) {
      leftFactor = this.dateTypeStack.pop();
    }

    String rightExpr = (String) visit(ctx.expression(1));
    if (!this.dateTypeStack.empty()) {
      rightFactor = this.dateTypeStack.pop();
    }

    return generateDateExprStr(leftFactor, rightFactor, op, leftExpr, rightExpr);
  }

  @Override
  public Object visitAnd(CnExprParser.AndContext ctx) {
    return visit(ctx.expression(0)) + " " + ctx.op.getText() + " " + visit(ctx.expression(1));
  }

  @Override
  public Object visitVariable(CnExprParser.VariableContext ctx) {
    Factor factor = factorMap.get(ctx.getText());

    //如果父节点是>、<、==等节点，并且此节点是日期型，那么把当前ctx压栈推迟处理
    if (ctx.getParent() instanceof CnExprParser.GreatLessContext || ctx.getParent() instanceof CnExprParser.EqualUnequalContext) {
      DateType dateType = getDateType(factor);
      if (dateType != null) { //如果是日期型
        this.dateTypeStack.push(factor);
        return null; //如果是日期型，会处理stack中的factorDef，所以可以返回null
      }
    }
    //不是日期型
    return factor.getCode();
  }

  @Override
  public Object visitPositiveAndNegative(CnExprParser.PositiveAndNegativeContext ctx) {
    return ctx.op.getText() + visit(ctx.expression());
  }

  @Override
  public Object visitExecFn(CnExprParser.ExecFnContext ctx) {
    Factor factor = factorMap.get(ctx.expression().getText());
    return factor.getCode() + visit(ctx.expressionList());
  }

  @Override
  public Object visitStartsWith(CnExprParser.StartsWithContext ctx) {
    return visit(ctx.expression(0)) + ".startsWith( " + visit(ctx.expression(1)) + ")";
  }

  @Override
  public Object visitExpressionList(CnExprParser.ExpressionListContext ctx) {
    List<String> childList = new ArrayList<>();
    for (CnExprParser.ExpressionContext childContext : ctx.expression()) {
      childList.add((String) visit(childContext));
    }
    return "(" + String.join(",", childList) + ")";

  }

  @Override
  public Object visitStringOrIdentifierArray(CnExprParser.StringOrIdentifierArrayContext ctx) {
    List<String> childList = new ArrayList<>();
    for (CnExprParser.StringOrIdentifierContext childContext : ctx.stringOrIdentifier()) {
      if (childContext.Identifier() != null) {
        childList.add(factorMap.get(childContext.Identifier().getText()).getCode());
      } else if (childContext.StringLiteral() != null) {
        childList.add(childContext.StringLiteral().getText());
      }
    }
    return "[" + String.join(",", childList) + "].flatten()";
  }

  @Override
  public Object visitDecimalOrIdentifierArray(CnExprParser.DecimalOrIdentifierArrayContext ctx) {
    List<String> childList = new ArrayList<>();
    for (CnExprParser.DecimalOrIdentifierContext childContext : ctx.decimalOrIdentifier()) {
      if (childContext.Identifier() != null) {
        childList.add(factorMap.get(childContext.Identifier().getText()).getCode());
      } else if (childContext.DecimalLiteral() != null) {
        childList.add(childContext.DecimalLiteral().getText());
      }
    }
    return "[" + String.join(",", childList) + "].flatten()";
  }

  @Override
  public Object visitStringOrIdentifier(CnExprParser.StringOrIdentifierContext ctx) {
    return ctx.getText();
  }

  @Override
  public Object visitDecimalOrIdentifier(CnExprParser.DecimalOrIdentifierContext ctx) {
    return ctx.getText();
  }

  @Override
  public Object visitLiteralArray(CnExprParser.LiteralArrayContext ctx) {
    return ctx.getText();
  }


  @Override
  public Object visitLiteral(CnExprParser.LiteralContext ctx) {
    return " " + ctx;
  }


}
