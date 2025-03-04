package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String genre;
    private String movieName;
    private int ageLimit;
    private int duration;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<MoviePlan> moviePlans;

    public List<MoviePlan> getMoviePlans() {
        return moviePlans;
    }

    public void setMoviePlans(List<MoviePlan> moviePlans) {
        this.moviePlans = moviePlans;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
