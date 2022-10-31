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
	public void doubleInputIsInvalid() {
		this.validate = new ValidateInputs();
		Boolean exp;

		exp = validate.doubleInputIsInvalid("");
		assertTrue(exp);

		exp = validate.doubleInputIsInvalid("N");
		assertTrue(exp);

		exp = validate.doubleInputIsInvalid("Five");
		assertTrue(exp);

		exp = validate.doubleInputIsInvalid("1M");
		assertTrue(exp);

		exp = validate.doubleInputIsInvalid("1.");
		assertFalse(exp);

		exp = validate.doubleInputIsInvalid("15");
		assertFalse(exp);

		exp = validate.doubleInputIsInvalid("1.54");
		assertFalse(exp);

		exp = validate.doubleInputIsInvalid("0.00");
		assertFalse(exp);
	}
	
	@Test
	public void InputIsInvalid() {
		this.validate = new ValidateInputs();
		Boolean exp;
		
		exp = validate.intInputIsInvalid("");
		assertTrue(exp);
		
		exp = validate.intInputIsInvalid("N");
		assertTrue(exp);
		
		exp = validate.intInputIsInvalid("Five");
		assertTrue(exp);
		
		exp = validate.intInputIsInvalid("1M");
		assertTrue(exp);
		
		exp = validate.intInputIsInvalid("1.");
		assertTrue(exp);
		
		exp = validate.intInputIsInvalid("1.54");
		assertTrue(exp);
		
		exp = validate.intInputIsInvalid("0.00");
		assertTrue(exp);
		
		exp = validate.intInputIsInvalid("15");
		assertFalse(exp);
		
		exp = validate.intInputIsInvalid("00");
		assertFalse(exp);
	}

}