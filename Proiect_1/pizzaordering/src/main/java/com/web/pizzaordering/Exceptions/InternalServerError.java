package com.web.pizzaordering.Exceptions;

public class InternalServerError extends RuntimeException{
    public InternalServerError() {
    }

    public InternalServerError(String message) {
        super(message);
    }

    public InternalServerError(String message, Throwable cause) {
        super(message, cause);
    }
}