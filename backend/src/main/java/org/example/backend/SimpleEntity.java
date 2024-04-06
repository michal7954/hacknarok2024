package org.example.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Deprecated(forRemoval = true)
@Entity
public class SimpleEntity {
    @Id
    private String name;
    private String description;

    public SimpleEntity() {
    }

    public SimpleEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
