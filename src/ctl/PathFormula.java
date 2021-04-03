package ctl;

/**
 * 
 * This class represents a CTL path formula.
 *
 */

public abstract class PathFormula extends Formula {

	public PathFormula() {}


	public abstract PathFormula existentialNormalForm();
	public abstract PathFormula positiveNormalForm();
}
