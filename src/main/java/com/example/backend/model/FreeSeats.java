package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect("SELECT id, name, age FROM users WHERE age > 18")
public class FreeSeats {
    @Id
    private Long id;
    private String name;
    private int age;
}

