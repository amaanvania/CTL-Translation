package ctlform;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ctl.Formula;
import ctl.Generator;
import parser.CTLLexer;
import parser.CTLParser;

public class PositiveNormalForm {
	
	public static Formula translate(Formula form) {
		Formula tempformula = form;
		
		String tempString = tempformula.toString();
		
		Generator gen = new Generator();
		
		//take in a formula
		
		//dissect it into its parts
			//how to dissect by the different sub-translations?
			//how to dissect distinct atomics from the original formula?
		
		//recursively perform the translations on each part starting from the inner and working towards the outer.
			//
		
		//combine it all together
		
		//apply visitor classes to go from string to Formula type
		
		String newstring = "";
		
		Formula positiveNormalForm = gen.visit(parseCtl(newstring));
		
		return positiveNormalForm;
	}
	
	private static ParseTree parseCtl(String ctlFormula) {
		CharStream input = CharStreams.fromString(ctlFormula);
		CTLLexer lexer = new CTLLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CTLParser parser = new CTLParser(tokens);
		ParseTree tree = parser.root();
		return tree;
	}

}
