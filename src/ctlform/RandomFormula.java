package ctlform;

import ctl.And;
import ctl.AtomicProposition;
import ctl.Exists;
import ctl.False;
import ctl.Formula;
import ctl.Not;
import ctl.Or;
import ctl.PathFormula;
import ctl.StateFormula;
import ctl.True;
import ctl.Until;

import java.util.Random;

public class RandomFormula {
	
	//Generate million cases, make sure unchanged (without ForAll)
	
	public static Formula RandomFormula (int depth) {
		Random randomform = new Random();
		String ap = null;
		StateFormula rand_form = null;
		StateFormula rand_form2 = null;
		
		if (depth == 0) {
			if (randomform.nextBoolean()) {
				rand_form = new True();
			}
			else {
				ap = "p1";
				rand_form = new AtomicProposition(ap);
			}
			switch (randomform.nextInt()) {
			case 1:
				//is this how we append to the formula?
				return new And(rand_form, rand_form);
			case 2:
				//is this how we append to the formula?
				return new Exists(null);
				//exists next
			case 3:
				//is this how we append to the formula?
				return new Not(rand_form2);
			case 4: 
				//exists until
			}
		}
		else if (depth == 1){
			if (randomform.nextBoolean()) {
				rand_form2 = new False();
			}
			else {
				ap = "p2";
				rand_form2 = new AtomicProposition(ap);
			}
			switch (randomform.nextInt()) {
			case 1:
				//is this how we append to the formula?
				return new And(rand_form, rand_form2);
			case 2:
				//is this how we append to the formula?
				return new Exists(null);
			case 3:
				//is this how we append to the formula?
				return new Not(rand_form2);
			case 4: 
				//
			}
		}
		
			
		
		
		//not sure what to return as the final result.
		return null;
		
		
		
	}

}
