package com.example.backend.controllers;

import com.example.backend.model.Movie;
import com.example.backend.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieRestController {

    @Autowired
    IMovieRepository iMovieRepository;

    @GetMapping("/")
    public String detteErRoden() {
        return "Du er i roden";
    }

    //GET
    @GetMapping("/movies")
    public List<Movie> movies() {
        return iMovieRepository.findAll();
    }
    @GetMapping("students/{name}") public List<Movie> allMoviesByName(@PathVariable String movieName) {
        return iMovieRepository.findAllBymovieName(movieName);
    }


}
