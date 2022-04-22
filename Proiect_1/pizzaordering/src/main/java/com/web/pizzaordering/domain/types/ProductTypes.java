package com.web.pizzaordering.domain.types;

public enum ProductTypes {
    PIZZA("Pizza"),
    DRINK("Drink");

    private final String displayName;

    ProductTypes(String value) {
        this.displayName = value;
    }

    public String getDisplayName() {
        return displayName;
    }

//    @Override
//    public String toString() {
//        return StringUtils.capitalize(name().toLowerCase());
//    }
}
