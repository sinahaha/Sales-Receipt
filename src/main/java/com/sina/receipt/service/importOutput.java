package com.sina.receipt.service;

public enum importOutput {

	TRUE(" imported "),
    FALSE(" ");

    private final String value;

    importOutput(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

