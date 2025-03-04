package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class MoviePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moviePlanId;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private ShowNumber showNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "movie_id", referencedColumnName = "movieId", nullable = false)
    private Movie movie;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "theater_id", referencedColumnName = "theaterId", nullable = true)
    private Theater theater;


    @OneToMany(mappedBy = "moviePlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Long getMoviePlanId() {
        return moviePlanId;
    }

    public void setMoviePlanId(Long moviePlanId) {
        this.moviePlanId = moviePlanId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ShowNumber getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(ShowNumber showNumber) {
        this.showNumber = showNumber;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
