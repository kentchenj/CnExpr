// Generated from C:/codebase/01_Java/cnexpr/src/main/resources\CnExpr.g4 by ANTLR 4.7
package com.kentchenj.cnexpr.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CnExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CnExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CnExprParser#cnExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCnExpr(CnExprParser.CnExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(CnExprParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constant}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(CnExprParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(CnExprParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code in}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(CnExprParser.InContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(CnExprParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code matches}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatches(CnExprParser.MatchesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(CnExprParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(CnExprParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code contains}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContains(CnExprParser.ContainsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greatLess}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreatLess(CnExprParser.GreatLessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalUnequal}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualUnequal(CnExprParser.EqualUnequalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(CnExprParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(CnExprParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code positiveAndNegative}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositiveAndNegative(CnExprParser.PositiveAndNegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code execFn}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecFn(CnExprParser.ExecFnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code startsWith}
	 * labeled alternative in {@link CnExprParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartsWith(CnExprParser.StartsWithContext ctx);
	/**
	 * Visit a parse tree produced by {@link CnExprParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(CnExprParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CnExprParser#stringOrIdentifierArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringOrIdentifierArray(CnExprParser.StringOrIdentifierArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link CnExprParser#decimalOrIdentifierArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalOrIdentifierArray(CnExprParser.DecimalOrIdentifierArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link CnExprParser#stringOrIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringOrIdentifier(CnExprParser.StringOrIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CnExprParser#decimalOrIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalOrIdentifier(CnExprParser.DecimalOrIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CnExprParser#literalArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralArray(CnExprParser.LiteralArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link CnExprParser#stringArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringArray(CnExprParser.StringArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link CnExprParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CnExprParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CnExprParser#decimalArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalArray(CnExprParser.DecimalArrayContext ctx);
}