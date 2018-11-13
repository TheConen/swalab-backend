package com.swalab.backend.exceptionhandling;

public class TechnicianNotFoundException extends ObjectNotFoundException {

    public TechnicianNotFoundException(String message) {
        super("There is no technician with name: " + message);
    }

    public TechnicianNotFoundException(String message, Throwable throwable) {
        super("There is no technician with name: " + message, throwable);
    }
}
