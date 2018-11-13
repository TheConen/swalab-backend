package com.swalab.backend.exceptionhandling;

public class WarehousePartAndOrderNotFoundException extends ObjectNotFoundException {

    public WarehousePartAndOrderNotFoundException(String message) {
        super("There is no part with ID: " + message);
    }

    public WarehousePartAndOrderNotFoundException(String message, Throwable throwable) {
        super("There is no part with ID: " + message, throwable);
    }
}
