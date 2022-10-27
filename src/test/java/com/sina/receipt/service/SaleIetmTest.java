package com.sina.receipt.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sina.receipt.service.SaleItem;

class SaleIetmTest {
	
	private SaleItem saleItem;

	@BeforeEach
	public void setUp() throws Exception {
		this.saleItem = new SaleItem();
	}

	@Test
	public void testGetItemTaxNormal() {
		this.saleItem.title = "CD";
		this.saleItem.quantitiy = 7;
		this.saleItem.unitPrice = 4.99;
		this.saleItem.taxExempt = false;
		this.saleItem.imported = false;

		double exp = 3.49;
		double act = saleItem.getItemTax();

		assertEquals(exp, act);
	}

	@Test
	public void testGetItemTaxNormalImported() {
		this.saleItem.title = "Japanese Film CD";
		this.saleItem.quantitiy = 23;
		this.saleItem.unitPrice = 7.99;
		this.saleItem.taxExempt = false;
		this.saleItem.imported = true;

		double exp = 27.57;
		double act = saleItem.getItemTax();

		assertEquals(exp, act);
	}
	
	@Test
	public void testGetItemTaxExempt() {
		this.saleItem.title = "Aspirin";
		this.saleItem.quantitiy = 6;
		this.saleItem.unitPrice = 14.99;
		this.saleItem.taxExempt = true;
		this.saleItem.imported = false;
		
		double exp = 0;
		double act = saleItem.getItemTax();
		
		assertEquals(exp, act);
	}
	
	@Test
	public void testGetItemTaxExemptImported() {
		this.saleItem.title = "American Dressing Sauce";
		this.saleItem.quantitiy = 5;
		this.saleItem.unitPrice = 13.99;
		this.saleItem.taxExempt = true;
		this.saleItem.imported = true;
		
		double exp = 3.50;
		double act = saleItem.getItemTax();
		
		assertEquals(exp, act);
	}
}
