package test;

import static ctlform.PositiveTranslation.*;
import static org.junit.jupiter.api.Assertions.*;

import ctl.Formula;
import ctl.Generator;
import ctlform.PositiveTranslation;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;
import parser.CTLLexer;
import parser.CTLParser;

class PositiveNormalFormTest {

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
	void testTranslatedDoubleNegation(){
		String input1 = "! ! True";
		Formula formula1 = getFormula(input1);

		Formula tester = formula1.positiveNormalForm();

		assertEquals("true", tester.toString());
	}

	@Test
	void testTranslatedNegatedTrue(){
		String input1 = "! True";
		Formula formula1 = getFormula(input1);

		Formula tester = formula1.positiveNormalForm();

		assertEquals("false", tester.toString());
	}

	@Test
	void testTranslatedNegatedFalse(){
		String input1 = "! false";
		Formula formula1 = getFormula(input1);

		Formula tester = formula1.positiveNormalForm();

		assertEquals("true", tester.toString());
	}
	@Test
	void testTranslatedNegatedAnd(){
		String input1 = "!(!Java.lang.Exception && !Java.lang.Runtime)";
		Formula formula1 = getFormula(input1);

		Formula tester = formula1.positiveNormalForm();

		System.out.println(tester.toString());
	}

	@Test
	void testTranslatedNegatedForAllNext(){
		String input1 = "!A X True";
		Formula formula1 = getFormula(input1);

		Formula tester = formula1.positiveNormalForm();

		System.out.println(tester.toString());
	}

	@Test
	void testTranslatedNegatedExistsNext(){
		String input1 = "!E X True";
		Formula formula1 = getFormula(input1);

		Formula tester = formula1.positiveNormalForm();

		System.out.println(tester.toString());
	}

	//to do
	@Test
	void testTranslatedNegatedExistsUntil(){
		String input1 = "!E(java.lang.Exception U java.lang.Exception)";
		Formula formula1 = getFormula(input1);

		Formula tester = formula1.positiveNormalForm();

		System.out.println(tester.toString());
	}

	//to do
	@Test
	void testTranslatedNegatedForAllUntil(){
		String input1 = "!A(java.lang.Exception U java.lang.Exception)";
		Formula formula1 = getFormula(input1);
		Formula tester = formula1.positiveNormalForm();
		System.out.println(tester.toString());
	}


}
