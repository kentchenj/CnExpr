package com.kentchenj.cnexpr.core;

import com.kentchenj.cnexpr.Expr;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 根据传入的代码，产生Groovy函数执行代码
 *
 * @author Kent Chen
 */
public class ScriptBuilder {
  private static ScriptBuilder scriptBuilder = new ScriptBuilder();
  private Map<String, Expr> exprMap = new HashMap<>();

  private ScriptBuilder() {
  }

  public static ScriptBuilder getInstance() {
    return scriptBuilder;
  }

  /**
   * 生成需要执行的代码
   *
   * @param expr
   * @return
   */
  public String build(Expr expr) {
    Expr exprStr = exprMap.get(expr.getExpr());
    if (exprStr != null) {
      return exprStr.getGroovyExpr();
    }
    Translator translator = new Translator(expr.getFactorMap());
    expr.setGroovyExpr(translator.translate(expr.getExpr()));

    String imports = expr.getImports().stream().collect(Collectors.joining(";\r\nimport ", "import ", ";\r\n"));
    String paraNames = String.join(",", expr.getParaNames());
    String template = "{0}def evalCnExpr({1})'{'{2}'}'" ;

    return MessageFormat.format(template, imports, paraNames, expr.getGroovyExpr());
  }
}
