package com.swalab.backend.exceptionhandling;

public class CustomerNotFoundException extends ObjectNotFoundException {

    public CustomerNotFoundException(String message) {
        super("There is no customer with ID: " + message);
    }

    public CustomerNotFoundException(String message, Throwable throwable) {
        super("There is no customer with ID: " + message, throwable);
    }
}
