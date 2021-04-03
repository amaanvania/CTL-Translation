package ctlform;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ctl.Formula;
import ctl.Generator;
import parser.CTLBaseVisitor;
import parser.CTLLexer;
import parser.CTLParser;

public class ExistentialNormalForm {
	
	public static Formula translate(Formula form) {		
		String tempString = form.toString();
		
		Formula existentialNormalForm = ExistentialTranslation.translation(tempString);
		
		return existentialNormalForm;
	}
}
