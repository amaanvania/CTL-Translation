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
	void testNotTrue() {
		String input = "! True";
		String input2 = "! false";
		Formula f1 = getFormula(input);
		Formula f2 = getFormula(input2);
		boolean b1 = PositiveTranslation.isNotTrue(f1);
		boolean b2 = PositiveTranslation.isNotTrue(f2);

		assertEquals(b1,true);
		assertEquals(b2,false);
	}

	@Test
	void testDoubleNegation() {
		String input = "! ! True";
		String input2 = "! False && ! True";
		Formula f1 = getFormula(input);
		Formula f2 = getFormula(input2);
		boolean b1 = PositiveTranslation.isDoubleNegation(f1);
		boolean b2 = PositiveTranslation.isDoubleNegation(f2);

		assertEquals(b1,true);
		assertEquals(b2,false);
	}

	@Test
	void testNegatedAnd() {
		String input = "! (java.lang.Error && java.lang.Exception)";
		String input2 = "! False && ! True";
		Formula f1 = getFormula(input);
		Formula f2 = getFormula(input2);
		boolean b1 = PositiveTranslation.isNegatedAnd(f1);
		boolean b2 = PositiveTranslation.isNegatedAnd(f2);

		assertEquals(b1,true);
		assertEquals(b2,false);
	}

	@Test
	void testNegatedForAllNext() {
		String input = "! A X (java.lang.Error)";
		String input2 = "! False && ! True";
		Formula f1 = getFormula(input);
		Formula f2 = getFormula(input2);
		boolean b1 = PositiveTranslation.isNegatedForAllNext(f1);
		boolean b2 = PositiveTranslation.isNegatedForAllNext(f2);

		assertEquals(b1,true);
		assertEquals(b2,false);
	}

	@Test
	void testNegatedExistsNext() {
		String input = "! E X (java.lang.Error)";
		String input2 = "! False && ! True";
		Formula f1 = getFormula(input);
		Formula f2 = getFormula(input2);
		boolean b1 = PositiveTranslation.isNegatedExistsNext(f1);
		boolean b2 = PositiveTranslation.isNegatedExistsNext(f2);

		assertEquals(b1,true);
		assertEquals(b2,false);
	}

	@Test
	void testNegatedForAllUntil() {
		String input = "! A (java.lang.Error U java.lang.Exception)";
		String input2 = "! False && ! True";
		Formula f1 = getFormula(input);
		Formula f2 = getFormula(input2);
		boolean b1 = PositiveTranslation.isNegatedForAllUntil(f1);
		boolean b2 = PositiveTranslation.isNegatedForAllUntil(f2);

		assertEquals(b1,true);
		assertEquals(b2,false);
	}

	@Test
	void testNegatedExistsUntil() {
		String input = "! E (java.lang.Error U java.lang.Exception)";
		String input2 = "! False && ! True";
		Formula f1 = getFormula(input);
		Formula f2 = getFormula(input2);
		boolean b1 = isNegatedExistsUntil(f1);
		boolean b2 = isNegatedExistsUntil(f2);

		assertEquals(b1,true);
		assertEquals(b2,false);
	}


	//to do
	@Test
	void testConvertedNegatedExistsUntil(){
		String input1 = "!E(java.lang.Exception U java.lang.Exception)";
		Formula formula1 = getFormula(input1);
		Boolean b1 = isNegatedExistsUntil(formula1);
		System.out.println(b1);
		if(b1){
			Formula converted = convertNegatedExistsUntil(formula1);
			formula1 = converted;
		}

		System.out.println(formula1.toString()); // 2nd line of output
	}

	//to do
	@Test
	void testConvertedNegatedForAllUntil(){
		String input1 = "!A(java.lang.Exception U java.lang.Exception)";
		Formula formula1 = getFormula(input1);
		Boolean b1 = isNegatedForAllUntil(formula1);
		System.out.println(b1);
		if(b1){
			Formula converted = convertNegatedForAllUntil(formula1);
			formula1 = converted;
		}

		System.out.println(formula1.toString()); // 2nd line of output
	}


}
