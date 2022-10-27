package com.sina.receipt.service;

import com.sina.receipt.calc.TaxRate;

public class SaleItem {
	private TaxRate rate;

	public String title;
	public int quantitiy;
	public double unitPrice;
	public Boolean taxExempt;
	public Boolean imported;

	public SaleItem() {
		this.rate = new TaxRate();
	}

	public double getItemTax() {
		return round5(this.getPrice() * this.rate.articleTaxRate(taxExempt, imported));
	}

	public String getTitle() {
		return title;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}

	public int getQuantity() {
		return quantitiy;
	}

	public double getPrice() {
		return quantitiy * unitPrice;
	}

	public Boolean getImported() {
		return imported;
	}

	private double round5(double tax) {
		int intPart = (int) tax;
		double decPart = tax - intPart;
		int firstAndSecondDecimal = (int) (decPart * 100);
		int thirdDecimal = (int) (decPart * 1000) % 10;

		firstAndSecondDecimal = thirdDecimal <= 4 ? firstAndSecondDecimal : firstAndSecondDecimal + 1;
		return intPart + (double) firstAndSecondDecimal / 100;
	}
}
