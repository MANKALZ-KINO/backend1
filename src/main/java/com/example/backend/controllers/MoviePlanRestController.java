package com.example.backend.controllers;

import com.example.backend.model.FreeSeats;
import com.example.backend.model.MoviePlan;

import com.example.backend.repositories.FreeSeatsRepository;
import com.example.backend.service.MoviePlanService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MoviePlanRestController {


    private final MoviePlanService moviePlanService;

    private FreeSeatsRepository freeSeatsRepository;

    public MoviePlanRestController(MoviePlanService moviePlanService, FreeSeatsRepository freeSeatsRepository) {
        this.moviePlanService = moviePlanService;
        this.freeSeatsRepository = freeSeatsRepository;
    }

    @GetMapping("/allseats")
    public List<FreeSeats> getFreeSeats() {
        List<FreeSeats> seats = freeSeatsRepository.findAll();

        // Debug output for at se, hvilke værdier der bliver hentet
        seats.forEach(seat -> System.out.println("Seat: " + seat.getShowNumber()));

        return seats;
    }



    //GET
    @GetMapping("/movieplans/{id}")
    public List<MoviePlan> moviePlansWithMovieId(@PathVariable Long id) {
        List<MoviePlan> moviePlanForMovie = new ArrayList<>();
        for (MoviePlan m : moviePlanService.moviePlansWithMovieId(id))
            if (m.getMovie().getMovieId() == id) {
                moviePlanForMovie.add(m);
            }
        return moviePlanForMovie;
    }

    //DELETE
    @DeleteMapping("/movieplan/{id}")
    public ResponseEntity<String> deleteMoviePlan(@PathVariable Long id) {
        Optional<MoviePlan> orgMoviePlan = moviePlanService.movieplans(id);
        if (orgMoviePlan.isPresent()) {
            moviePlanService.deleteMovieById(id);
            return ResponseEntity.ok("movieplan deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("movieplan not found and could not be deleted");
        }
    }


}
