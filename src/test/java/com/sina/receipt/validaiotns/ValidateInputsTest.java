package com.sina.receipt.validaiotns;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.sina.receipt.validations.ValidateInputs;

public class ValidateInputsTest {

	private ValidateInputs validate;

	@Test
	public void booleanInputIsInvalid() {
		this.validate = new ValidateInputs();
		Boolean exp;

		exp = validate.booleanInputIsInvalid("");
		assertTrue(exp);

		exp = validate.booleanInputIsInvalid("M");
		assertTrue(exp);

		exp = validate.booleanInputIsInvalid(" Y");
		assertTrue(exp);

		exp = validate.booleanInputIsInvalid("YN");
		assertTrue(exp);

		exp = validate.booleanInputIsInvalid("Y");
		assertFalse(exp);

		exp = validate.booleanInputIsInvalid("N");
		assertFalse(exp);
	}

	@Test
	public void numericalInputIsInvalid() {
		this.validate = new ValidateInputs();
		Boolean exp;

		exp = validate.numericalInputIsInvalid("");
		assertTrue(exp);

		exp = validate.numericalInputIsInvalid("N");
		assertTrue(exp);

		exp = validate.numericalInputIsInvalid("Five");
		assertTrue(exp);

		exp = validate.numericalInputIsInvalid("1M");
		assertTrue(exp);

		exp = validate.numericalInputIsInvalid("1.");
		assertFalse(exp);

		exp = validate.numericalInputIsInvalid("15");
		assertFalse(exp);

		exp = validate.numericalInputIsInvalid("1.54");
		assertFalse(exp);

		exp = validate.numericalInputIsInvalid("0.00");
		assertFalse(exp);
	}

}