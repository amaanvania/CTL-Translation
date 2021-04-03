package parser;
import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ctl.Formula;
import ctl.Generator;

public class Main {

	public static void main(String[] args) {
		try {
			String filename = args[0];
			CharStream input = CharStreams.fromFileName(filename);
			CTLLexer lexer = new CTLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			CTLParser parser = new CTLParser(tokens);
			ParseTree tree = parser.root();
			System.out.println(tree.toStringTree()); // 1st line of output
			Generator generator = new Generator();
			Formula formula = generator.visit(tree);
			System.out.println(formula.toString()); // 2nd line of output
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Provide a command line argument");
		} catch (IOException e) {
			System.out.println("Something went wrong with reading the input");			
		}
	}
}
