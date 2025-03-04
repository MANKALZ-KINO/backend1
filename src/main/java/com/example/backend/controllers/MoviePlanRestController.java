package com.example.backend.controllers;
import com.example.backend.model.MoviePlan;
import com.example.backend.repositories.IMoviePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    IMoviePlanRepository iMoviePlanRepository;

    //GET
    @GetMapping("/movieplans/{id}")
    public List<MoviePlan> moviePlansWithMovieId(@PathVariable Long id) {
        List<MoviePlan> moviePlanForMovie = new ArrayList<>();
        for (MoviePlan m : iMoviePlanRepository.findAll())
            if (m.getMovie().getMovieId() == id){
                moviePlanForMovie.add(m);
            }
        return moviePlanForMovie;
    }
    //DELETE
    @DeleteMapping("/movieplan/{id}")
    public ResponseEntity<String> deleteMoviePlan(@PathVariable Long id) {
        Optional<MoviePlan> moviePlan = iMoviePlanRepository.findById(id);
        if (moviePlan.isPresent()) {
            iMoviePlanRepository.deleteById(id);
            return ResponseEntity.ok("MoviePlan with id " + id + " deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("MoviePlan not found.");
    }


}
