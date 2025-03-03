package com.example.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cinema {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long cinemaId;

    private String name;
    private String address;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<Theater> theaters;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Cinema() {

    }

    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
