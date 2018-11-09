package com.swalab.backend.model;

import com.swalab.backend.database.IdGenerator;

import java.util.Date;

public abstract class AbstractTaskAndNote {

    private final Long id = IdGenerator.getNewId();
    private String title;
    private String description;
    private Date creationDate;

    public AbstractTaskAndNote() {
    }

    public AbstractTaskAndNote(String title, String description, Date creationDate) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }
}
