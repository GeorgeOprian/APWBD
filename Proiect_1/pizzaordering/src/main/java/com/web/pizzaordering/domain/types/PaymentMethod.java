package com.web.pizzaordering.domain.types;

public enum PaymentMethod {
    CASH(1, "Cash"),
    CARD(2, "Card");

    private int value;
    private String methodName;

    PaymentMethod(int value, String methodName) {
        this.value = value;
        this.methodName = methodName;
    }
}
