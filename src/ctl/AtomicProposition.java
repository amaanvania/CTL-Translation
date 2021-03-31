package ctl;

/**
 * 
 * This class represents an <i>atomic proposition</i> formula in CTL.
 * 
 */

public class AtomicProposition extends StateFormula {

	String formula;		// the name of a static boolean field of some Java class

	/**
	 * Initializes the {@code formula} field to the provided {@code name}.
	 * @param	name	A string representing a static boolean field defined in some Java class
	 */
	public AtomicProposition(String name) {
		this.formula = name;
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
		AtomicProposition other = (AtomicProposition) obj;
		if (formula == null) {
			if (other.formula != null)
				return false;
		} else if (!formula.equals(other.formula))
			return false;
		return true;
	}

	/**
	 * Returns the {@code hashCode} of this <i>AtomicProposition</i> formula.
	 * @return	An integer value representing this object's {@code hashCode}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formula == null) ? 0 : formula.hashCode());
		return result;
	}

	/**
	 * Returns a string representation of this <i>AtomicProposition</i> formula.
	 * @return A pretty print version of this formula.
	 */
	@Override
	public String toString() {
		return this.formula;
	}
	
	
}
