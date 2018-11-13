package com.swalab.backend.exceptionhandling;

public class AvailablePartNotFoundException extends ObjectNotFoundException {

    public AvailablePartNotFoundException(String message) {
        super("There is no part with ID: " + message);
    }

    public AvailablePartNotFoundException(String message, Throwable throwable) {
        super("There is no part with ID: " + message, throwable);
    }
}
