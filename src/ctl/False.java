package ctl;

/**
 * 
 * This class represents a <i>False</i> formula in CTL.
 * 
 */

public class False extends StateFormula {

	boolean formula;	// store as a primitive boolean for the smallest footprint
	
	/**
	 * Initializes the {@code formula} field to <i>false</i>.
	 */
	public False() {
		this.formula = false;
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
		False other = (False) obj;
		if (formula != other.formula)
			return false;
		return true;
	}

	/**
	 * Returns the {@code hashCode} of this <i>False</i> formula.
	 * @return	An integer value representing this object's {@code hashCode}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (formula ? 1231 : 1237);
		return result;
	}

	/**
	 * Returns a string representation of this <i>False</i> formula.
	 * @return A pretty print version of this formula.
	 */
	@Override
	public String toString() {
		return String.valueOf(formula);
	}

}
