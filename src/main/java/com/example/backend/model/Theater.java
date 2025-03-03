package com.example.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long theaterId;

    private String theaterName;
    @ManyToOne
    @JoinColumn(name = "cinema_id", referencedColumnName = "cinemaId", nullable = false)
    private Cinema cinema;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Seat> seats;


    public long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(long theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
