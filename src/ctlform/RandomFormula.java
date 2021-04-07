package ctlform;

import ctl.*;

import java.util.Random;

public class RandomFormula {

    //Generate million cases, make sure unchanged (without ForAll)

    public static Formula UntranslatableRandomFormula(int depth) {
        Random r = new Random();

        if (depth == 0)
        	if(r.nextBoolean())
            return generateUntranslatableStateFormula(0);
        	else return generateUntranslatablePathFormula(0);
        else if (r.nextBoolean())
            return generateUntranslatablePathFormula(depth - 1);
        else
            return generateUntranslatableStateFormula(depth - 1);


    }


    public static StateFormula generateUntranslatableStateFormula(int depth) {
        Random r = new Random();
        if (depth <= 0) {
			//TODO - ADD more base cases such as atomics
            if (r.nextBoolean() && r.nextBoolean())
                return new False();
            else return new True();

        } else {
			//generate random int between 1 - 3 (inclusive)
            int curr = r.nextInt(3) + 1;
            switch (curr) {
                case 1:
                    //is this how we append to the formula?
                    return new And(generateUntranslatableStateFormula(depth - 1), generateUntranslatableStateFormula(depth - 1));
                case 2:
                    return new Or(generateUntranslatableStateFormula(depth - 1), generateUntranslatableStateFormula(depth - 1));
                case 3:
                    return new Implies(generateUntranslatableStateFormula(depth - 1), generateUntranslatableStateFormula(depth - 1));
                default:
                    return new Iff(generateUntranslatableStateFormula(depth - 1), generateUntranslatableStateFormula(depth - 1));
            }
        }

    }

    public static PathFormula generateUntranslatablePathFormula(int depth) {
        Random r = new Random();

        //generate random int between 1 - 5 (inclusive)
        int curr = r.nextInt(5) + 1;
        if (depth <= 0) {

            switch (curr) {
                case 1:
                    return new Always(generateUntranslatableStateFormula(0));
                case 2:
                    return new Eventually(generateUntranslatableStateFormula(0));
                case 3:
                    return new Next(generateUntranslatableStateFormula(0));
                case 4:
                    return new WeakUntil(generateUntranslatableStateFormula(0), generateUntranslatableStateFormula(0));
                default:
                    return new Until(generateUntranslatableStateFormula(0), generateUntranslatableStateFormula(0));
            }

        } else {

            switch (curr) {
                case 1:
                    return new Always(generateUntranslatableStateFormula(depth - 1));
                case 2:
                    return new Eventually(generateUntranslatableStateFormula(depth - 1));
                case 3:
                    return new Next(generateUntranslatableStateFormula(depth - 1));
                case 4:
                    return new WeakUntil(generateUntranslatableStateFormula(depth - 1), generateUntranslatableStateFormula(depth - 1));
                default:
                    return new Until(generateUntranslatableStateFormula(depth - 1), generateUntranslatableStateFormula(depth - 1));
            }
        }
    }


    //method which produces PNF translatable formula
    public static Formula translatablePNFRandomFormula(int depth) {
        Random r = new Random();

        if (depth == 0)
            if (r.nextBoolean())
                return generateTranslatablePositiveStateFormula(0);
            else return UntranslatableRandomFormula(0);


        else
            return generateTranslatablePositiveStateFormula(depth - 1);



    }

    //helper method to produce PNF state formula
    public static StateFormula generateTranslatablePositiveStateFormula(int depth) {
        Random r = new Random();
        if (depth <= 0) {
        	//TODO - ADD more base cases such as atomics
            if (r.nextBoolean() && r.nextBoolean())
                return new Not(new False());
            else return new Not(new True());

        } else {

            int curr = r.nextInt(5) + 1;
            switch (curr) {
                case 1:
                	//!And
                    return new Not(new And(generateTranslatablePositiveStateFormula(depth - 1), generateTranslatablePositiveStateFormula(depth - 1)));
                case 2:
                	//!ForAllNext
                    return new Not(new ForAll(new Next(generateTranslatablePositiveStateFormula(depth - 1))));
                case 3:
                	//!ForAllUntil
                    return new Not(new ForAll(new Until(generateTranslatablePositiveStateFormula(depth - 1), generateTranslatablePositiveStateFormula(depth - 1))));
				case 4:
					//!ExistsUntil
					return new Not(new Exists(new Until(generateTranslatablePositiveStateFormula(depth - 1),generateTranslatablePositiveStateFormula(depth - 1))));
				default:
					//!ExistsNext
					return new Not(new Exists(new Next(generateTranslatablePositiveStateFormula(depth - 1))));
            }
        }

    }

/*    public static PathFormula generateTranslatablePositivePathFormula(int depth) {
        Random r = new Random();
        int curr = r.nextInt(5) + 1;
        if (depth <= 0) {

            switch (curr) {
                case 1:
                    return new Always(generateTranslatablePositiveStateFormula(0));
                case 2:
                    return new Eventually(generateTranslatablePositiveStateFormula(0));
                case 3:
                    return new Next(generateTranslatablePositiveStateFormula(0));
                case 4:
                    return new WeakUntil(generateTranslatablePositiveStateFormula(0), generateTranslatablePositiveStateFormula(0));
                default:
                    return new Until(generateTranslatablePositiveStateFormula(0), generateTranslatablePositiveStateFormula(0));
            }

        } else {

            switch (curr) {
                case 1:
                    return new Always(generateTranslatablePositiveStateFormula(depth - 1));
                case 2:
                    return new Eventually(generateTranslatablePositiveStateFormula(depth - 1));
                case 3:
                    return new Next(generateTranslatablePositiveStateFormula(depth - 1));
                case 4:
                    return new WeakUntil(generateTranslatablePositiveStateFormula(depth - 1), generateTranslatablePositiveStateFormula(depth - 1));
                default:
                    return new Until(generateTranslatablePositiveStateFormula(depth - 1), generateTranslatablePositiveStateFormula(depth - 1));
            }
        }
    }*/




	//method which produces a random ENF translatable formula
	public static Formula translatableENFRandomFormula(int depth) {
		Random r = new Random();

		if (depth == 0)
			if (r.nextBoolean())
				return generateTranslatableExistentialStateFormula(0);
			else return UntranslatableRandomFormula(0);


		else
			return generateTranslatableExistentialStateFormula(depth - 1);



	}


	//helper method to produce ENF state formula
	public static StateFormula generateTranslatableExistentialStateFormula(int depth) {
		Random r = new Random();
		if (depth <= 0) {
			//TODO - ADD more base cases such as atomics
			if (r.nextBoolean() && r.nextBoolean())
				return new AtomicProposition("ap");
			else return new True();

		} else {

			int curr = r.nextInt(4) + 1;
			switch (curr) {
				case 1:
					//ForAllNext
					return new ForAll(new Next(generateTranslatableExistentialStateFormula(depth - 1)));
				case 2:
					//ForAllUntil
					return new ForAll(new Until(generateTranslatableExistentialStateFormula(depth - 1), generateTranslatableExistentialStateFormula(depth - 1)));
				case 3:
					//ForAllUntil v2
					return new ForAll(new Until(generateUntranslatableStateFormula(depth - 1), generateTranslatableExistentialStateFormula(depth - 1)));
				default:
					//ForAllNext v2
					return new ForAll(new Next(generateUntranslatableStateFormula(depth - 1)));
			}
		}

	}
}
