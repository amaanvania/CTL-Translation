package test;

import ctl.Formula;
import ctl.Generator;
import ctlform.ExistentialNormalForm;
import ctlform.RandomFormula;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;
import parser.CTLLexer;
import parser.CTLParser;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

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
	void testFormulaUnchanged(){

		for(int i = 0; i < 10000; i++) {
			Formula generated = RandomFormula.UntranslatableRandomFormula(10);
			Formula translated = generated.existentialNormalForm();
			assertEquals(translated.toString(), generated.toString());
		}

	}

	@Test
	void testFormulaChanged(){
		for(int i = 0; i < 10000; i++) {
			Formula generated = RandomFormula.translatablePNFRandomFormula(10);
			Formula translated = generated.positiveNormalForm();
			boolean isSame = translated.toString().equals(generated.toString());
			assertEquals(false,isSame);
		}
	}


	@Test
	void testTranslatedForAllNext() {
		String in = "AX(java.lang.Error)";
		Formula formula = getFormula(in);
		Formula g = ExistentialNormalForm.translate(formula);

		System.out.println(g.toString());
	}

	@Test
	void testTranslatedForAllUntil() {
		String in = "AX(java.lang.Error)";
		String in1 = "A (" + in + "U " + in +")";
		Formula formula = getFormula(in1);
		Formula g = ExistentialNormalForm.translate(formula);

		Formula gg = g.existentialNormalForm();

		System.out.println(g.toString());

		System.out.println(gg.toString());
	}



}
