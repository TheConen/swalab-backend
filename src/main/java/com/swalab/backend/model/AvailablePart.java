package com.swalab.backend.model;

import com.swalab.backend.database.IdGenerator;

import java.util.Objects;

public class AvailablePart {

    private long id = IdGenerator.getNewId();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id < 0) {
            this.id = IdGenerator.getNewId();
        } else {
            this.id = id;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailablePart that = (AvailablePart) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
