package com.example.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class MoviePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moviePlanId;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private ShowNumber showNumber;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movieId", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theater_id", referencedColumnName = "theaterId", nullable = false)
    private Theater theater;

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
