package com.swalab.backend.model;

import com.swalab.backend.database.IdGenerator;

public class AvailablePart {

    private final Long id = IdGenerator.getNewId();
    private String name;
    private String description;

    public AvailablePart() {
    }

    public AvailablePart(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }
}
