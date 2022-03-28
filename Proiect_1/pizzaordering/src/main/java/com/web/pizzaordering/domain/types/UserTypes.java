package com.web.pizzaordering.domain.types;

public enum UserTypes {
    ADMINISTRATOR (1, "Administrator"),
    CUSTOMER (2, "Customer");

    private int value;
    private String type;

    UserTypes(int value, String type) {
        this.value = value;
        this.type = type;
    }
}
