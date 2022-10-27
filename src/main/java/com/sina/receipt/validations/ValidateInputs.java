package com.sina.receipt.validations;

import org.apache.commons.lang3.math.NumberUtils;

public class ValidateInputs {

	public Boolean booleanInputIsInvalid(String input) {
		return !input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N") ? true : false;
	}

	public Boolean numericalInputIsInvalid(String input) {
		return !NumberUtils.isCreatable(input) ? true : false;
	}

}
