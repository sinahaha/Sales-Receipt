package com.sina.receipt.calc;

public class TaxRate {
	public double articleTaxRate(Boolean taxExempt, Boolean imported) {
		int itemTax;
		itemTax = taxExempt ? 0 : 10;
		itemTax = imported  ? itemTax + 5 : itemTax;
		return (double) itemTax / 100;
	}
}
