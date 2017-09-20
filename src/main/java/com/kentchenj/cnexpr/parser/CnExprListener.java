// Generated from C:/codebase/01_Java/cnexpr/src/main/resources\CnExpr.g4 by ANTLR 4.7
package com.kentchenj.cnexpr.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CnExprParser}.
 */
public interface CnExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CnExprParser#cnExpr}.
	 * @param ctx the parse tree
	 */
	void enterCnExpr(CnExprParser.CnExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CnExprParser#cnExpr}.
	 * @param ctx the parse tree
	 */
	void exitCnExpr(CnExprParser.CnExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParens(CnExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParens(CnExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constant}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstant(CnExprParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constant}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstant(CnExprParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOr(CnExprParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOr(CnExprParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code in}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIn(CnExprParser.InContext ctx);
	/**
	 * Exit a parse tree produced by the {@code in}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIn(CnExprParser.InContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(CnExprParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(CnExprParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code matches}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMatches(CnExprParser.MatchesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code matches}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMatches(CnExprParser.MatchesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(CnExprParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(CnExprParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNot(CnExprParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNot(CnExprParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code contains}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterContains(CnExprParser.ContainsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code contains}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitContains(CnExprParser.ContainsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greatLess}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreatLess(CnExprParser.GreatLessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greatLess}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreatLess(CnExprParser.GreatLessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalUnequal}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualUnequal(CnExprParser.EqualUnequalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalUnequal}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualUnequal(CnExprParser.EqualUnequalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(CnExprParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(CnExprParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variable}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CnExprParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CnExprParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code positiveAndNegative}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPositiveAndNegative(CnExprParser.PositiveAndNegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code positiveAndNegative}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPositiveAndNegative(CnExprParser.PositiveAndNegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code execFn}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExecFn(CnExprParser.ExecFnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code execFn}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExecFn(CnExprParser.ExecFnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code startsWith}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStartsWith(CnExprParser.StartsWithContext ctx);
	/**
	 * Exit a parse tree produced by the {@code startsWith}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStartsWith(CnExprParser.StartsWithContext ctx);
	/**
	 * Enter a parse tree produced by {@link CnExprParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(CnExprParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CnExprParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(CnExprParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CnExprParser#stringOrIdentifierArray}.
	 * @param ctx the parse tree
	 */
	void enterStringOrIdentifierArray(CnExprParser.StringOrIdentifierArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link CnExprParser#stringOrIdentifierArray}.
	 * @param ctx the parse tree
	 */
	void exitStringOrIdentifierArray(CnExprParser.StringOrIdentifierArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link CnExprParser#decimalOrIdentifierArray}.
	 * @param ctx the parse tree
	 */
	void enterDecimalOrIdentifierArray(CnExprParser.DecimalOrIdentifierArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link CnExprParser#decimalOrIdentifierArray}.
	 * @param ctx the parse tree
	 */
	void exitDecimalOrIdentifierArray(CnExprParser.DecimalOrIdentifierArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link CnExprParser#stringOrIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterStringOrIdentifier(CnExprParser.StringOrIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CnExprParser#stringOrIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitStringOrIdentifier(CnExprParser.StringOrIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CnExprParser#decimalOrIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterDecimalOrIdentifier(CnExprParser.DecimalOrIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CnExprParser#decimalOrIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitDecimalOrIdentifier(CnExprParser.DecimalOrIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CnExprParser#literalArray}.
	 * @param ctx the parse tree
	 */
	void enterLiteralArray(CnExprParser.LiteralArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link CnExprParser#literalArray}.
	 * @param ctx the parse tree
	 */
	void exitLiteralArray(CnExprParser.LiteralArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link CnExprParser#stringArray}.
	 * @param ctx the parse tree
	 */
	void enterStringArray(CnExprParser.StringArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link CnExprParser#stringArray}.
	 * @param ctx the parse tree
	 */
	void exitStringArray(CnExprParser.StringArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link CnExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CnExprParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CnExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CnExprParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CnExprParser#decimalArray}.
	 * @param ctx the parse tree
	 */
	void enterDecimalArray(CnExprParser.DecimalArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link CnExprParser#decimalArray}.
	 * @param ctx the parse tree
	 */
	void exitDecimalArray(CnExprParser.DecimalArrayContext ctx);
}