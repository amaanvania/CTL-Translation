package parser;
// Generated from .\CTL.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CTLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CTLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CTLParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(CTLParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Bracket}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracket(CTLParser.BracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForAllAlways}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAllAlways(CTLParser.ForAllAlwaysContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(CTLParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Iff}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIff(CTLParser.IffContext ctx);
	/**
	 * Visit a parse tree produced by the {@code True}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(CTLParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code False}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(CTLParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExistsEventually}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsEventually(CTLParser.ExistsEventuallyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomicProposition}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicProposition(CTLParser.AtomicPropositionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForAllEventually}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAllEventually(CTLParser.ForAllEventuallyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(CTLParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForAllUntil}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAllUntil(CTLParser.ForAllUntilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplies(CTLParser.ImpliesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForAllNext}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAllNext(CTLParser.ForAllNextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(CTLParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExistsAlways}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsAlways(CTLParser.ExistsAlwaysContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExistsUntil}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsUntil(CTLParser.ExistsUntilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExistsNext}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsNext(CTLParser.ExistsNextContext ctx);
}