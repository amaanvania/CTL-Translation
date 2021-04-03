package ctl;

/**
 * 
 * This class represents a CTL formula.
 *
 */

public abstract class Formula {

	public Formula() {}
	
	public abstract boolean equals(Object obj);
	public abstract int hashCode();
	public abstract String toString();
	public abstract Formula existentialNormalForm();
	public abstract Formula positiveNormalForm();

	
}
