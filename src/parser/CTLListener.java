package parser;
// Generated from .\CTL.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CTLParser}.
 */
public interface CTLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CTLParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(CTLParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link CTLParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(CTLParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Bracket}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterBracket(CTLParser.BracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Bracket}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitBracket(CTLParser.BracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForAllAlways}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForAllAlways(CTLParser.ForAllAlwaysContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForAllAlways}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForAllAlways(CTLParser.ForAllAlwaysContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterOr(CTLParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitOr(CTLParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Iff}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterIff(CTLParser.IffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Iff}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitIff(CTLParser.IffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code True}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterTrue(CTLParser.TrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code True}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitTrue(CTLParser.TrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code False}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterFalse(CTLParser.FalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code False}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitFalse(CTLParser.FalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsEventually}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterExistsEventually(CTLParser.ExistsEventuallyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsEventually}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitExistsEventually(CTLParser.ExistsEventuallyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AtomicProposition}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAtomicProposition(CTLParser.AtomicPropositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AtomicProposition}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAtomicProposition(CTLParser.AtomicPropositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForAllEventually}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForAllEventually(CTLParser.ForAllEventuallyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForAllEventually}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForAllEventually(CTLParser.ForAllEventuallyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterNot(CTLParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitNot(CTLParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForAllUntil}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForAllUntil(CTLParser.ForAllUntilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForAllUntil}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForAllUntil(CTLParser.ForAllUntilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterImplies(CTLParser.ImpliesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitImplies(CTLParser.ImpliesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForAllNext}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterForAllNext(CTLParser.ForAllNextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForAllNext}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitForAllNext(CTLParser.ForAllNextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAnd(CTLParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAnd(CTLParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsAlways}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterExistsAlways(CTLParser.ExistsAlwaysContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsAlways}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitExistsAlways(CTLParser.ExistsAlwaysContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsUntil}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterExistsUntil(CTLParser.ExistsUntilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsUntil}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitExistsUntil(CTLParser.ExistsUntilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistsNext}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterExistsNext(CTLParser.ExistsNextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistsNext}
	 * labeled alternative in {@link CTLParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitExistsNext(CTLParser.ExistsNextContext ctx);
}