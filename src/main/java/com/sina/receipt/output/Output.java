package com.sina.receipt.output;

import java.util.ArrayList;

import com.sina.receipt.calc.CalculateTax;
import com.sina.receipt.service.SaleItem;

public class Output {

	private double finalPrice;
	private double finalTax;

	private ArrayList<SaleItem> saleList = new ArrayList<SaleItem>();

	public void checkout(ArrayList<SaleItem> saleList) {
		this.saleList = saleList;

		calculateRecepit();
		printRecepit();
	}

	private void calculateRecepit() {
		for (SaleItem item : this.saleList) {
			finalPrice += item.getPrice();
			finalTax += item.getItemTax();
		}
	}

	public void printRecepit() {

		System.out.println("\n\n");

		this.saleList.forEach((item) -> {

			CalculateTax details = new CalculateTax(item);

			System.out.println(details.getQuantitiy() + details.getImportedArticleOnInvoice() + details.getTitle()
					+ String.format("%.2f", details.getTaxedPrice()));
		});

		System.out.println("=============================================");
		System.out.println("Sales Taxes: " + String.format("%.2f", this.finalTax));
		System.out.println("Total: " + String.format("%.2f", this.finalPrice));
	}

}
