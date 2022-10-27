package com.sina.receipt.output;

import java.util.ArrayList;

import com.sina.receipt.service.SaleIetm;
import com.sina.receipt.service.importOutput;

public class Output {
	
	private double finalPrice;
	private double finalTax;

	private ArrayList<SaleIetm> saleList = new ArrayList<SaleIetm>();
	
	public void checkout(ArrayList<SaleIetm> saleList) {
		this.saleList = saleList;
		
		calculateRecepit();
		printRecepit();
	}

	public void calculateRecepit() {
		for(SaleIetm item: this.saleList) {
			finalPrice += item.getPrice();
			finalTax += item.getItemTax();
		}
	}
	
	public void printRecepit() {
		this.saleList.forEach((item) -> {
			double taxedPrice = item.getItemTax() + item.getPrice();
			System.out.println(
					item.getQuantity()
					+ imported(item)
					+ item.getTitle() + ": "
					+ String.format( "%.2f", taxedPrice)
					);}
		);

		System.out.println("=============================================");
		System.out.println("Sales Taxes: " + String.format( "%.2f", this.finalTax));
		System.out.println("Total: " + String.format( "%.2f", this.finalPrice));
	}
	
	private String imported(SaleIetm item) {
		return item.getImported() ? importOutput.TRUE.getValue() : importOutput.FALSE.getValue();
	}

}
