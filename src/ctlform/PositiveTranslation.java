package ctlform;

import ctl.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.CTLLexer;
import parser.CTLParser;

public class PositiveTranslation {

    public static void main(String[] args) {
        try {
            String input1 = "!(!Java.lang.Exception && !Java.lang.Runtime)";
            Formula formula1 = getFormula(input1);

            Formula tester = PositiveNormalForm.translateUntilComplete(formula1);

            System.out.println(tester.toString());
/*            Boolean b1 = isNegatedExistsUntil(formula1);
          //  System.out.println(b1);
            if(b1){
                Formula converted = convertNegatedExistsUntil(formula1);
                formula1 = converted;
            }*/






        } catch (IndexOutOfBoundsException e) {
            System.out.println("Provide a command line argument");
        }
    }
    
    public static Formula translation(String in) {
    	Formula f = getFormula(in);
    	
    	if (isNegatedForAllNext(f)) {
    		
    	}
    	else if (isNotTrue(f)) {
    		
    	}
    	else if (isDoubleNegation(f)) {
    		
    	}
    	else if (isNegatedAnd(f)) {
    		
    	}
    	else if (isNegatedForAllNext(f)) {
    		convertNegatedForAllNext(f);
    	}
    	else if (isNegatedExistsNext(f)) {
    		convertNegatedExistsNext(f);
    	}
    	else if (isNegatedForAllUntil(f)) {
    		convertNegatedForAllUntil(f);
    	}
    	else if (isNegatedExistsUntil(f)) {
    		convertNegatedExistsUntil(f);
    	}
    	
    	return f;
    }

    // ! True
    public static boolean isNotTrue(Formula f){
        if(f != null && f instanceof Not){
            Not curr = (Not) f;
            return (curr.inner != null && curr.inner instanceof True);
        }
        return false;
    }

    // ! ! True
    public static boolean isDoubleNegation(Formula f){
        if(f != null && f instanceof Not){
            Not curr = (Not) f;
            return (curr.inner != null && curr.inner instanceof Not);
        }
        return false;
    }


    // !(p1 && p2)
    public static boolean isNegatedAnd(Formula f){
        if(f != null && f instanceof Not){
            Not curr = (Not) f;
            return (curr.inner != null && curr.inner instanceof And);
        }
        return false;
    }

    // !AX(p1)
    public static boolean isNegatedForAllNext(Formula f){
        if(f != null && f instanceof Not){
            Not curr = (Not) f;
            if(curr != null && curr.inner instanceof ForAll){
                ForAll next = (ForAll) curr.inner;
                return (next.getInner() != null && next.getInner() instanceof Next);
            }
        }
        return false;
    }

    // !EX(p1)
    public static boolean isNegatedExistsNext(Formula f){
        if(f != null && f instanceof Not){
            Not curr = (Not) f;
            if(curr.inner != null && curr.inner instanceof Exists){
                Exists next = (Exists) curr.inner;
                return (next.getInner() != null && next.getInner() instanceof Next);
            }
        }
        return false;
    }

    // !A(p1 U p2)
    public static boolean isNegatedForAllUntil(Formula f){
        if(f != null && f instanceof Not){
            Not curr = (Not) f;
            if(curr != null && curr.inner instanceof ForAll){
                ForAll next = (ForAll) curr.inner;
                return (next.getInner() != null && next.getInner() instanceof Until);
            }
        }
        return false;
    }

    // !A(p1 U p2)
    public static boolean isNegatedExistsUntil(Formula f){
        if(f != null && f instanceof Not){
            Not curr = (Not) f;
            if(curr != null && curr.inner instanceof Exists){
                Exists next = (Exists) curr.inner;
                return (next.getInner() != null && next.getInner() instanceof Until);
            }
        }
        return false;
    }


    public static Formula convertNotTrue(Formula f){
        if(f != null && f instanceof Not){
            Not curr = (Not) f;
            if(curr.inner != null && curr.inner instanceof True){
                return new False();
            }
        }
        return f;
    }

    public static Formula convertNegatedForAllNext(Formula f){
        if(f != null && f instanceof Not){
            Not curr = (Not) f;
            if(curr != null && curr.inner instanceof ForAll){
                ForAll next = (ForAll) curr.inner;
                if (next.getInner() != null && next.getInner() instanceof Next){
                    Next last = (Next) next.getInner();
                    return new Exists(new Next(new Not(last.inner)));
                }
            }
        }
        return f;
    }

    public static Formula convertNegatedExistsNext(Formula f){
        if(f != null && f instanceof Not){
            Not curr = (Not) f;
            if(curr.inner != null && curr.inner instanceof Exists){
                Exists next = (Exists) curr.inner;
                if(next.getInner() != null && next.getInner() instanceof Next){
                    Next last = (Next) next.getInner();
                    return new ForAll(new Next(new Not(last.inner)));
                }
            }
        }
        return f;
    }

    public static Formula convertNegatedForAllUntil(Formula f){
        if(f != null && f instanceof Not){
            Not curr = (Not) f;
            if(curr.inner != null && curr.inner instanceof ForAll){
                ForAll next = (ForAll) curr.inner;
                if (next.getInner() != null && next.getInner() instanceof Until){
                    Until last = (Until) next.getInner();
                    StateFormula left = last.left;
                    StateFormula right = last.right;

                    StateFormula leftInsideBracket = new And(left, new Not(right));
                    StateFormula rightInsideBracket = new And(new Not(left), new Not(right));

                    Formula result = new Exists(new WeakUntil(leftInsideBracket,rightInsideBracket));
                    return result;

                }
            }
        }
        return f;
    }


    public static Formula convertNegatedExistsUntil(Formula f){
        if(f != null && f instanceof Not){
            Not curr = (Not) f;
            if(curr != null && curr.inner instanceof Exists){
                Exists next = (Exists) curr.inner;
                if (next != null && next.getInner() instanceof Until){
                    Until last = (Until) next.getInner();
                    StateFormula left = last.left;
                    StateFormula right = last.right;

                    StateFormula leftInsideBracket = new And(left, new Not(right));
                    StateFormula rightInsideBracket = new And(new Not(left), new Not(right));

                    Formula result = new ForAll(new WeakUntil(leftInsideBracket,rightInsideBracket));
                    return result;
                }
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

