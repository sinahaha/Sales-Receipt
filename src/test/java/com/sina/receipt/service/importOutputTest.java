package com.sina.receipt.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class importOutputTest {

	@Test
	public void testImported() {
		String act = " imported ";
		String exp = ImportOutput.TRUE.getValue();

		assertEquals(act, exp);
	}

	@Test
	public void testNotImported() {
		String act = " ";
		String exp = ImportOutput.FALSE.getValue();

		assertEquals(act, exp);
	}
}
