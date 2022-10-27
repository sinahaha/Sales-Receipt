package com.sina.receipt.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaxRateTest {

	private TaxRate rate;

	private int normal = 10;
	private int importedNormal = 15;

	private int taxExempt = 0;
	private int importedtaxExempt = 5;

	@BeforeEach
	public void setUp() throws Exception {
		this.rate = new TaxRate();
	}

	@Test
	public void normalRate() {
		double act, exp;
		Boolean taxExempt = false, imported = false;

		act = (double) this.normal / 100;
		exp = rate.articleTaxRate(taxExempt, imported);
		assertEquals(act, exp);
	}

	@Test
	public void importedNormalRate() {
		double act, exp;
		Boolean taxExempt = false, imported = true;

		act = (double) this.importedNormal / 100;
		exp = rate.articleTaxRate(taxExempt, imported);
		assertEquals(act, exp);
	}

	@Test
	public void taxExemptRate() {
		double act, exp;
		Boolean taxExempt = true, imported = false;

		act = (double) this.taxExempt / 100;
		exp = rate.articleTaxRate(taxExempt, imported);
		assertEquals(act, exp);
	}

	@Test
	public void importedtaxExemptRate() {
		double act, exp;
		Boolean taxExempt = true, imported = true;

		act = (double) this.importedtaxExempt / 100;
		exp = rate.articleTaxRate(taxExempt, imported);
		assertEquals(act, exp);
	}

}
