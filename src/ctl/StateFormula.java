package ctl;

/**
 * 
 * This class represents a CTL state formula.
 *
 */

public abstract class StateFormula extends Formula {

	public StateFormula() {}
	public abstract StateFormula existentialNormalForm();
	public abstract StateFormula positiveNormalForm();
	
}
