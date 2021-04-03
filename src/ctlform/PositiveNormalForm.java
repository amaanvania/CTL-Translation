package ctlform;

import ctl.Formula;

public class PositiveNormalForm {

	public static Formula translate(Formula form) {

		Formula result = form.positiveNormalForm();

		return result;
	}


	//translate until no more translations possible
	public static Formula translateUntilComplete(Formula form) {

		Formula result = form.positiveNormalForm();
		for(int i = 0; i < 50; i++){
			Formula tempResult = result.positiveNormalForm();
			if(tempResult.equals(result)) break;
			result = tempResult;
		}
		return result;

	}
}
