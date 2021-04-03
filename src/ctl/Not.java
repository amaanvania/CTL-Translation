package ctl;

/**
 * 
 * This class represents a negation of a CTL state formula.
 * 
 */

public class Not extends StateFormula {

	public StateFormula inner;	// the inner StateFormula that is being negated
	
	/**
	 * Initializes the {@code inner} formula to the <i>StateFormula</i>
	 * provided to this constructor.
	 * @param	formula		A state formula
	 */
	public Not(StateFormula formula) {
		this.inner = formula;
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
		Not other = (Not) obj;
		if (inner == null) {
			if (other.inner != null)
				return false;
		} else if (!inner.equals(other.inner))
			return false;
		return true;
	}

	/**
	 * Returns the {@code hashCode} of this <i>Not</i> formula.
	 * @return	An integer value representing this object's {@code hashCode}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inner == null) ? 0 : inner.hashCode());
		return result;
	}

	/**
	 * Returns a string representation of this <i>Not</i> formula.
	 * @return A pretty print version of this formula. The {@code left} and
	 * 		   {@code right} formulas are each enclosed in brackets.
	 */
	@Override
	public String toString() {
		return "!(" + inner.toString() + ")";
	}

	@Override
	public StateFormula existentialNormalForm() {
		return new Not(inner.existentialNormalForm());
	}

	@Override
	public StateFormula positiveNormalForm() {
		if(inner instanceof True){ //works
			return new False();
		} if(inner instanceof False){
			return new True();
		} if(inner instanceof Not){ //works
			Not curr = (Not) inner;
			return curr.inner.positiveNormalForm();
		} if(inner instanceof And){

			And curr = (And) inner;
			return new Or(new Not(curr.left.positiveNormalForm()), new Not(curr.right.positiveNormalForm()));

		} if(inner instanceof ForAll){
			ForAll curr = (ForAll) inner;

			if(curr.getInner() != null){

				if(curr.getInner() instanceof Next){

					Next last = (Next) curr.getInner();
					return new Exists(new Next(new Not(last.inner.positiveNormalForm())));

				}else if(curr.getInner() instanceof Until){

					Until last = (Until) curr.getInner();
					StateFormula left = last.left;
					StateFormula right = last.right;

					StateFormula leftInsideBracket = new And(left.positiveNormalForm(), new Not(right.positiveNormalForm()));
					StateFormula rightInsideBracket = new And(new Not(left.positiveNormalForm()), new Not(right.positiveNormalForm()));
					return new Exists(new WeakUntil(leftInsideBracket,rightInsideBracket));

				}
			}
		} if(inner instanceof Exists){
			Exists curr = (Exists) inner;

			if(curr.getInner() != null){

				if(curr.getInner() instanceof Next){

					Next last = (Next) curr.getInner();
					return new ForAll(new Next(new Not(last.inner.positiveNormalForm())));

				}else if(curr.getInner() instanceof Until){

					Until last = (Until) curr.getInner();
					StateFormula left = last.left;
					StateFormula right = last.right;

					StateFormula leftInsideBracket = new And(left.positiveNormalForm(), new Not(right.positiveNormalForm()));
					StateFormula rightInsideBracket = new And(new Not(left.positiveNormalForm()), new Not(right.positiveNormalForm()));
					return new ForAll(new WeakUntil(leftInsideBracket,rightInsideBracket));

				}
			}
		}

		return new Not(inner.positiveNormalForm());
	}
}
