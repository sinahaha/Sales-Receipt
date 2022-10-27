package com.sina.receipt.calc;

import com.sina.receipt.service.SaleItem;
import com.sina.receipt.service.ImportOutput;

public class CalculateTax {

	private SaleItem item;

	public CalculateTax(SaleItem item) {
		this.item = item;
	}

	public SaleItem getItem() {
		return item;
	}

	public String getTitle() {
		return this.item.getTitle() + ": ";
	}

	public int getQuantitiy() {
		return this.item.getQuantity();
	}

	public double getTaxedPrice() {
		return this.item.getItemTax() + this.item.getPrice();
	}

	public String getImportedArticleOnInvoice() {
		return importedArticleOnInvoice(this.item.imported);
	}

	private String importedArticleOnInvoice(Boolean imported) {
		return imported ? ImportOutput.TRUE.getValue() : ImportOutput.FALSE.getValue();
	}
}
