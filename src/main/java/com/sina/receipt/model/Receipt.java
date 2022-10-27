package com.sina.receipt.model;

import com.sina.receipt.output.Output;
import com.sina.receipt.service.Invoice;

public class Receipt {
	private Invoice invoice;
	private Output output;

	public Receipt() {
		this.invoice = new Invoice();
		this.output = new Output();
	}

	public void salesReceipt() {
		invoice.saleItems();

		output.checkout(invoice.getSaleList());
	}
}