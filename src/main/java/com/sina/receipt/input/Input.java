package com.sina.receipt.input;

import java.util.Scanner;

import com.sina.receipt.service.SaleIetm;
import com.sina.receipt.validations.ValidateInputs;

public class Input {

	ValidateInputs validation = new ValidateInputs();

	public SaleIetm inputItem(Scanner scan) {
		SaleIetm item = new SaleIetm();

		System.out.println("Please enter the name (and unit of the article with underscores e.g. 'CD' or 'bottle_of_wine':");
		item.title = scan.next();

		System.out.println("Please enter the quantity of the article:");
		item.quantitiy = readInt(scan);

		System.out.println("Please price per unit:");
		item.unitPrice = readDouble(scan);

		System.out.println("Is the article imported?");
		item.imported = readBoolean(scan);

		System.out.println("Is the article tax exempt?");
		item.taxExempt = readBoolean(scan);

		 return item;
	}

	private int readInt(Scanner scan) {
		String response;
		Boolean inputIsInvalid = false;

		do {
			response = scan.next();
			inputIsInvalid = this.validation.numericalInputIsInvalid(response);

			if (inputIsInvalid) {
				System.out.println(String.format("%s is not a correct number; please enter a correct numbner.", response));
			}

		} while (inputIsInvalid);

		return Integer.parseInt(response);
	}
	
	private double readDouble(Scanner scan) {
		String response;
		Boolean inputIsInvalid = false;
		
		do {
			response = scan.next();
			inputIsInvalid = this.validation.numericalInputIsInvalid(response);
			
			if (inputIsInvalid) {
				System.out.println(String.format("%s is not a correct number; please enter a correct numbner.", response));
			}
			
		} while (inputIsInvalid);

		return Double.parseDouble(response);
	}

	private boolean readBoolean(Scanner scan) {
		String response;
		boolean result = false, invalid = true;

		do {
			response = scan.next();
			invalid = this.validation.booleanInputIsInvalid(response);

			if (response.equalsIgnoreCase("Y")) {
				result = true;

			} else if (response.equalsIgnoreCase("N")) {
				result = false;

			}

		} while (invalid);

		return result;
	}
}
