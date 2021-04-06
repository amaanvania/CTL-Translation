package ctl;

import javax.swing.plaf.nimbus.State;

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
		}
		//further simplify
		if(inner instanceof And){

			And curr = (And) inner;
			StateFormula left = new Not(curr.left.positiveNormalForm());
			StateFormula right = new Not(curr.right.positiveNormalForm());

			//further simplify as new not
			return new Or(left.positiveNormalForm(), right.positiveNormalForm());

		} if(inner instanceof ForAll){
			ForAll curr = (ForAll) inner;

			if(curr.getInner() != null){

				//Not(ForAll(Next))
				if(curr.getInner() instanceof Next){

					Next last = (Next) curr.getInner();

					StateFormula innerNot = new Not(last.inner.positiveNormalForm());

					//since we add a not, check if simplified
					return new Exists(new Next(innerNot.positiveNormalForm()));


				}
				//Not(ForAll(Until))
				else if(curr.getInner() instanceof Until){

					Until last = (Until) curr.getInner();
					StateFormula left = last.left;
					StateFormula right = last.right;

					//left part of Until translated (saves computation)
					StateFormula leftTranslated = left.positiveNormalForm();

					//right part of Until translated (saves computation)
					StateFormula rightTranslated = right.positiveNormalForm();

					//inner right part of both right and left
					StateFormula innerRightPart = new Not(rightTranslated);

					//since we add a not, check if further simplification
					StateFormula innerRightPartTranslated = innerRightPart.positiveNormalForm();


					StateFormula leftInsideBracket = new And(leftTranslated, innerRightPartTranslated);

					StateFormula leftInnerPart = new Not(leftTranslated);

					//simplify because we are adding a Not
					StateFormula leftInRightBracketTranslated = leftInnerPart.positiveNormalForm();

					//combine left and right, to create AND
					StateFormula rightInsideBracket = new And(leftInRightBracketTranslated, innerRightPartTranslated);

					//combine left bracket and right bracket with Exists(Weak Until)
					return new Exists(new WeakUntil(leftInsideBracket,rightInsideBracket));

				}
			}
		} if(inner instanceof Exists){
			Exists curr = (Exists) inner;

			if(curr.getInner() != null){

				if(curr.getInner() instanceof Next){

					Next last = (Next) curr.getInner();

					StateFormula innerNot = new Not(last.inner.positiveNormalForm());

					//since we add a Not, simplify
					StateFormula innerNotTranslated = innerNot.positiveNormalForm();

					return new ForAll(new Next(innerNotTranslated));

				}
				// Negated Exists Until (!E (Φ U Ψ))
				else if(curr.getInner() instanceof Until){

					Until last = (Until) curr.getInner();
					StateFormula left = last.left;
					StateFormula right = last.right;

					//left part of Until translated (saves computation)
					StateFormula leftTranslated = left.positiveNormalForm();

					//right part of Until translated (saves computation)
					StateFormula rightTranslated = right.positiveNormalForm();

					//inner right part of both right and left brackets
					StateFormula innerRightPart = new Not(rightTranslated);

					//since we add a not, check if further simplification
					StateFormula innerRightPartTranslated = innerRightPart.positiveNormalForm();

					//left bracket is now done (left of implies)
					StateFormula leftInsideBracket = new And(leftTranslated, innerRightPartTranslated);

					//left part of right bracket
					StateFormula leftInnerPart = new Not(leftTranslated);

					//simplify because we are adding a Not
					StateFormula leftInRightBracketTranslated = leftInnerPart.positiveNormalForm();

					//combine left and right, to create AND
					StateFormula rightInsideBracket = new And(leftInRightBracketTranslated, innerRightPartTranslated);

					//combine left bracket and right bracket with Exists(Weak Until)
					return new ForAll(new WeakUntil(leftInsideBracket,rightInsideBracket));

				}
			}
		}

		return new Not(inner.positiveNormalForm());
	}
}
