package com.sina.receipt.output;

import java.util.ArrayList;

import com.sina.receipt.calc.calculateTax;
import com.sina.receipt.service.SaleIetm;

public class Output {

	private double finalPrice;
	private double finalTax;

	private ArrayList<SaleIetm> saleList = new ArrayList<SaleIetm>();

	public void checkout(ArrayList<SaleIetm> saleList) {
		this.saleList = saleList;

		calculateRecepit();
		printRecepit();
	}

	private void calculateRecepit() {
		for (SaleIetm item : this.saleList) {
			finalPrice += item.getPrice();
			finalTax += item.getItemTax();
		}
	}

	public void printRecepit() {

		System.out.println("\n\n");

		this.saleList.forEach((item) -> {

			calculateTax details = new calculateTax(item);

			System.out.println(details.getQuantitiy() + details.getImportedArticleOnInvoice() + details.getTitle()
					+ String.format("%.2f", details.getTaxedPrice()));
		});

		System.out.println("=============================================");
		System.out.println("Sales Taxes: " + String.format("%.2f", this.finalTax));
		System.out.println("Total: " + String.format("%.2f", this.finalPrice));
	}

}
