package model;

import java.util.UUID;

public class BaseModel {
    protected UUID id;
    protected String name;

    public BaseModel() {
    }

    public BaseModel(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
