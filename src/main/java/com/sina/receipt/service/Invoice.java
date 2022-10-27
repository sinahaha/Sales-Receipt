package com.sina.receipt.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sina.receipt.input.Input;
import com.sina.receipt.validations.ValidateInputs;

public class Invoice {
	private ArrayList<SaleIetm> saleList = new ArrayList<SaleIetm>();

	public ArrayList<SaleIetm> getSaleList() {
		return this.saleList;
	}

	public void saleItems() {
		Input input= new Input();
		Boolean moreItems = true;

		try (Scanner scan = new Scanner(System.in)) {

			do {
				String response;

				System.out.println("Add an item? (Y/N)");
				response = scan.next().toUpperCase();

				if (response.equals("Y")) {
					saleList.add(input.inputItem(scan));

				} else if (response.equals("N")) {
					moreItems = false;
				} else {
					System.out.println("Please enter 'Y' or 'N'.");
				}

			} while (moreItems);

		} catch (InputMismatchException e) {
			System.out.println("Wrong pattern");
		}

	}
}
