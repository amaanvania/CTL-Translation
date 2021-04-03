package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import ctl.Generator;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;

import ctl.And;
import ctl.Formula;
import parser.CTLLexer;
import parser.CTLParser;

class ExistentialNormalFormTest {

	private static Formula getFormula(String in) {
		CharStream input = CharStreams.fromString(in);
		CTLLexer lexer = new CTLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CTLParser parser = new CTLParser(tokens);
		ParseTree tree = parser.root();
		Generator generator = new Generator();
		return generator.visit(tree);
	}

	@Test
	void testTranslatedForAllNext() {
		String in = "AX(java.lang.Error)";
		Formula formula = getFormula(in);
		Formula g = formula.existentialNormalForm();

		System.out.println(g.toString());
	}

	@Test
	void testTranslatedForAllUntil() {
		String in = "A (java.lang.Exception U java.lang.RuntimeException)";
		Formula formula = getFormula(in);
		Formula g = formula.existentialNormalForm();

		System.out.println(g.toString());
	}



}
