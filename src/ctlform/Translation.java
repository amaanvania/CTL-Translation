package ctlform;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ctl.Always;
import ctl.And;
import ctl.Exists;
import ctl.ForAll;
import ctl.Formula;
import ctl.Generator;
import ctl.Next;
import ctl.Not;
import ctl.StateFormula;
import ctl.Until;
import parser.CTLLexer;
import parser.CTLParser;

public class Translation {

		public static void main(String[] args) {
			try {
				String in = "(A (java.lang.Exception U java.lang.Exception) && AX(java.lang.Exception))";
				CTLParser temp = getParser(in);
				//System.out.println(temp.toString());
				ParseTree root = temp.root();
				//System.out.println(root.toString());
				Formula formula = getFormula(in);

				if(formula instanceof And) {
					Formula tempLeft = ((And) formula).left;

					Formula tempRight = ((And) formula).right;

					System.out.println(tempLeft.toString());


					if(isForAllNext(tempRight)) {
						System.out.println("Right is ForAllNext");
						Formula f = convertForAllNext(tempRight);
						System.out.println(f.toString());
						((And) formula).right = (StateFormula) f;
					}

					if(isForAllUntil(tempLeft)) {
						System.out.println("Left is ForAllUntil");
						Formula f = convertForAllUntil(tempLeft);
						System.out.println(f.toString());
						((And) formula).left = (StateFormula) f;
					}

				}

				System.out.println(formula.toString()); // 2nd line of output
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Provide a command line argument");
			}
		}

		public static boolean isForAllNext(Formula f){
			if(f != null && f instanceof ForAll){
				if(((ForAll) f).getInner() != null && ((ForAll) f).getInner() instanceof Next){
					return true;
				}
			}
			return false;
		}

		public static boolean isForAllUntil(Formula f){
			if(f != null && f instanceof ForAll){
				if(((ForAll) f).getInner() != null && ((ForAll) f).getInner() instanceof Until){
					return true;
				}
			}
			return false;
		}

		public static Formula convertForAllNext(Formula f){
			if(f instanceof ForAll){
				Formula inner = ((ForAll) f).getInner();

				if(inner instanceof Next){
					Formula next = ((Next) inner).inner;
					if(next instanceof StateFormula) {
						System.out.println("Worked");
						return new Not(new Exists(new Next(new Not((StateFormula) next))));
					}
				}
			}
			return f;
		}

		public static Formula convertForAllUntil(Formula f){
			if(f instanceof ForAll){
				Formula inner = ((ForAll) f).getInner();

				if(inner instanceof Until){
					StateFormula left = ((Until) inner).left;
					StateFormula right = ((Until) inner).left;
					StateFormula leftInnerAnd = new And(new Not(left), new Not(right));
					Until leftUntil = new Until(new Not(right), leftInnerAnd);
					StateFormula leftPart = new Not(new Exists(leftUntil));
					StateFormula rightPart = new Not(new Exists(new Always(new Not(right))));
					Formula result = new And(leftPart,rightPart);
					return result;
				}
			}
			return f;
		}
		private static Formula getFormula(String in) {
			CharStream input = CharStreams.fromString(in);
			CTLLexer lexer = new CTLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			CTLParser parser = new CTLParser(tokens);
			ParseTree tree = parser.root();
			//System.out.println(tree.toStringTree()); // 1st line of output
			Generator generator = new Generator();
			return generator.visit(tree);
		}

		private static CTLParser getParser(String in){
			CharStream input = CharStreams.fromString(in);
			CTLLexer lexer = new CTLLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			CTLParser parser = new CTLParser(tokens);
			return parser;
		}
	}
