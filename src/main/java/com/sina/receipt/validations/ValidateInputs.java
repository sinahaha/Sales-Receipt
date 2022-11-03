package com.sina.receipt.validations;

import java.util.regex.Pattern;

public class ValidateInputs {

	public Boolean booleanInputIsInvalid(String input) {
		return !input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N") ? true : false;
	}

	public Boolean doubleInputIsInvalid(String input) {
		return !(Pattern.matches("([0-9]+)([\\.]?)([0-9]*)", input) || Pattern.matches("([0-9]*)([\\.]?)([0-9]+)", input)) ? true : false;
	}

	public Boolean intInputIsInvalid(String input) {
		return !input.matches("[0-9]+") ? true : false;
	}

}
