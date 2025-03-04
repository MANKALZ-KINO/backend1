package com.example.backend.controllers;
import com.example.backend.model.Movie;
import com.example.backend.model.MoviePlan;
import com.example.backend.repositories.IMoviePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MoviePlanRestController {

    @Autowired
    IMoviePlanRepository iMoviePlanRepository;

    @GetMapping("/moviePlans{id}")
    public List<MoviePlan> moviePlans(@PathVariable int id) {
        List<MoviePlan> moviePlanForMovie = new ArrayList<>();
        for (MoviePlan m : iMoviePlanRepository.findAll())
            if (m.getMovie().getMovieId() == id){
                moviePlanForMovie.add(m);
            }
        return moviePlanForMovie;
    }


}
