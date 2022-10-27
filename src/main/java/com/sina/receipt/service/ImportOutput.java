package com.sina.receipt.service;

public enum ImportOutput {

	TRUE(" imported "),
    FALSE(" ");

    private final String value;

    ImportOutput(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

