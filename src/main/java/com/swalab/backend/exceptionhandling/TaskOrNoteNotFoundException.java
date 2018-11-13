package com.swalab.backend.exceptionhandling;

public class TaskOrNoteNotFoundException extends ObjectNotFoundException {

    public TaskOrNoteNotFoundException(String message) {
        super("There is no note/task with ID: " + message);
    }

    public TaskOrNoteNotFoundException(String message, Throwable throwable) {
        super("There is no note/task with ID: " + message, throwable);
    }
}
