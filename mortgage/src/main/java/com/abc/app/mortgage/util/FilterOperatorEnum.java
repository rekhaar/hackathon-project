package com.abc.app.mortgage.util;

public enum FilterOperatorEnum {
    EQUALS("Equals"),
    CONTAINS("Like"),
    GT("GT");
    private final String operator;

    String getOperator() {
        return operator;
    }

    FilterOperatorEnum(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return operator;
    }
}
