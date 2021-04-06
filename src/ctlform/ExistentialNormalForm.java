package ctlform;

import ctl.Formula;

public class ExistentialNormalForm {
	
	public static Formula translate(Formula form) {
		return form.existentialNormalForm();
	}


	//translate until no more translations possible
	public static Formula translateUntilComplete(Formula form) {

		Formula result = form.existentialNormalForm();
		for(int i = 0; i < 50; i++){
			Formula tempResult = result.existentialNormalForm();
			if(tempResult.equals(result)) break;
			result = tempResult;
		}
		return result;

	}
}
