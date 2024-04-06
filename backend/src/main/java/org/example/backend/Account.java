package org.example.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Deprecated(forRemoval = true)
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    public Account(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Account() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
