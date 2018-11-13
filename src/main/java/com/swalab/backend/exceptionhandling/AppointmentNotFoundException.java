package com.swalab.backend.exceptionhandling;

public class AppointmentNotFoundException extends ObjectNotFoundException {

    public AppointmentNotFoundException(String message) {
        super("There is no appointment with ID: " + message);
    }

    public AppointmentNotFoundException(String message, Throwable throwable) {
        super("There is no appointment with ID: " + message, throwable);
    }
}
