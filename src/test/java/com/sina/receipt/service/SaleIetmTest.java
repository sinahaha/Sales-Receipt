package com.sina.receipt.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sina.receipt.service.SaleIetm;

class SaleIetmTest {
	
	private SaleIetm saleIetm;

	@BeforeEach
	public void setUp() throws Exception {
		this.saleIetm = new SaleIetm();
	}

	@Test
	public void testGetItemTaxNormal() {
		this.saleIetm.title = "CD";
		this.saleIetm.quantitiy = 7;
		this.saleIetm.unitPrice = 4.99;
		this.saleIetm.taxExempt = false;
		this.saleIetm.imported = false;

		double exp = 3.49;
		double act = saleIetm.getItemTax();

		assertEquals(exp, act);
	}

	@Test
	public void testGetItemTaxNormalImported() {
		this.saleIetm.title = "Japanese Film CD";
		this.saleIetm.quantitiy = 23;
		this.saleIetm.unitPrice = 7.99;
		this.saleIetm.taxExempt = false;
		this.saleIetm.imported = true;

		double exp = 27.57;
		double act = saleIetm.getItemTax();

		assertEquals(exp, act);
	}
	
	@Test
	public void testGetItemTaxExempt() {
		this.saleIetm.title = "Aspirin";
		this.saleIetm.quantitiy = 6;
		this.saleIetm.unitPrice = 14.99;
		this.saleIetm.taxExempt = true;
		this.saleIetm.imported = false;
		
		double exp = 0;
		double act = saleIetm.getItemTax();
		
		assertEquals(exp, act);
	}
	
	@Test
	public void testGetItemTaxExemptImported() {
		this.saleIetm.title = "American Dressing Sauce";
		this.saleIetm.quantitiy = 5;
		this.saleIetm.unitPrice = 13.99;
		this.saleIetm.taxExempt = true;
		this.saleIetm.imported = true;
		
		double exp = 3.50;
		double act = saleIetm.getItemTax();
		
		assertEquals(exp, act);
	}
}
