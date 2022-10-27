package com.sina.receipt.calc;

import com.sina.receipt.service.SaleIetm;
import com.sina.receipt.service.importOutput;

public class calculateTax {

	private SaleIetm item;

	public calculateTax(SaleIetm item) {
		this.item = item;
	}

	public SaleIetm getItem() {
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
		return imported ? importOutput.TRUE.getValue() : importOutput.FALSE.getValue();
	}
}
