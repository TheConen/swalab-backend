package com.swalab.backend.model;

import java.util.Date;

public class Note extends AbstractTaskAndNote {

    public Note() {
    }

    public Note(String title, String description, Date creationDate) {
        super(title, description, creationDate);
    }

}
