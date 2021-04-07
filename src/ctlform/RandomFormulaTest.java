package ctlform;

import ctl.Formula;

public class RandomFormulaTest {


    public static void main(String[] args){

        Formula f = RandomFormula.translatableENFRandomFormula(10);

        System.out.println(f.toString());


        Formula g = f.existentialNormalForm();



        System.out.println(g.toString());


        System.out.println(g.toString().equals(f.toString()));
    }
}
