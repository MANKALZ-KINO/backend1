package com.example.backend.controllers;

import com.example.backend.model.Movie;
import com.example.backend.model.MoviePlan;
import com.example.backend.repositories.IMovieRepository;
import com.example.backend.service.MoviePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieRestController {

    @Autowired
    IMovieRepository iMovieRepository;

    @Autowired
    MoviePlanService moviePlanService;

    @GetMapping("/")
    public String detteErRoden() {
        return "Du er i roden";
    }

    //GET
    @GetMapping("/movies")
    public List<Movie> movies() {
        return iMovieRepository.findAll();
    }
    @GetMapping("/movies/{name}") public List<Movie> allMoviesByName(@PathVariable String name) {
        return iMovieRepository.findAllBymovieName(name);
    }
    //DELETE
    // DELETE Movie
    @DeleteMapping("/movie/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        Optional<Movie> movie = iMovieRepository.findById(id);

        if (movie.isPresent()) {
            // Hent MoviePlans for den givne Movie
            List<MoviePlan> moviePlans = movie.get().getMoviePlans();

            // Slet kun MoviePlans, hvis der er nogen
            if (moviePlans != null && !moviePlans.isEmpty()) {
                moviePlans.forEach(moviePlan -> moviePlanService.deleteMoviePlan(moviePlan.getMoviePlanId()));
            }

            // Slet filmen bagefter
            iMovieRepository.deleteById(id);

            return ResponseEntity.ok("Movie and related MoviePlans deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found and not deleted");
        }
    }




}
