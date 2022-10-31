package com.sina.receipt.validations;

import org.apache.commons.lang3.math.NumberUtils;

public class ValidateInputs {

	public Boolean booleanInputIsInvalid(String input) {
		return !input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N") ? true : false;
	}

	public Boolean doubleInputIsInvalid(String input) {
		return !NumberUtils.isCreatable(input) ? true : false;
	}

	public Boolean intInputIsInvalid(String input) {
		
		return !input.matches("[0-9]+") ? true : false;
	}

}
