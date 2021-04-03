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
		String tempString = form.toString();
		
		Formula positiveNormalForm = PositiveTranslation.translation(tempString);
		
		return positiveNormalForm;
	}
}
