package com.sina.receipt.service;

import com.sina.receipt.calc.TaxRate;

public class SaleItem {

	/*
	 * NOTE: Crystal clear, even though it's said there's no correct code, it is
	 * absolutely necessary to have begun this data model with an 'ID', since the
	 * 'title' or 'name' of the goods means nothing and could not be unique
	 * (repeated, translatable, etc). Therefore, this data model must start only
	 * contain an ID field plus, a quantity field only, and the rest of the fields
	 * shall be retrieved from the database. Like:
	 * 
	 * public String id; public int quantitiy;
	 * 
	 * However, here, as I haven't prepared a list of good in a database, I made the
	 * coding simpler by reading the input (since I just wanted to deliver my
	 * solution to a problem), but then it is a bit harder for the user to type in
	 * everything!
	 */

	public String title;
	public int quantitiy;
	public double unitPrice;
	public Boolean taxExempt;
	public Boolean imported;

	private TaxRate rate;

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
