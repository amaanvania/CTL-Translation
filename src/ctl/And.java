package ctl;

/**
 * 
 * This class represents a conjunction of two CTL state formulas.
 * 
 */

public class And extends StateFormula {

	public StateFormula left;
	public StateFormula right;
	
	/**
	 * Initializes the {@code left} and {@code right} sub-formulas to the state
	 * formulas provided to this constructor.
	 * @param	left	The left sub-formula
	 * @param	right	The right sub-formula
	 */
	public And(StateFormula left, StateFormula right) {
		this.left = left;
		this.right = right;
	}

	/**
	 * Checks if this Formula is equal another object. The checks adhere to the
	 * Equals contract in Java.
	 * @param	obj		The other object that this Formula is being compared to.
	 * @return	Returns <i>true</i> if the two objects are equal, and <i>false</i>
	 * 			if otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		And other = (And) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}

	/**
	 * Returns the {@code hashCode} of this <i>And</i> formula.
	 * @return	An integer value representing this object's {@code hashCode}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	/**
	 * Returns a string representation of this <i>And</i> formula.
	 * @return A pretty print version of this formula. The {@code left} and
	 * 		   {@code right} sub-formulas are each enclosed in brackets.
	 */
	@Override
	public String toString() {
		return "(" + left.toString() + ")&&(" + right.toString() + ")";
	}
	
}
