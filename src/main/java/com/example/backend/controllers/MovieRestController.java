package com.example.backend.controllers;

import com.example.backend.model.Movie;
import com.example.backend.model.MoviePlan;
import com.example.backend.repositories.IMoviePlanRepository;
import com.example.backend.repositories.IMovieRepository;
import com.example.backend.repositories.ITicketRepository;
import com.example.backend.service.MoviePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
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
    @GetMapping("/movies/{name}") public List<Movie> allMoviesByName(@PathVariable String name) {
        return iMovieRepository.findAllBymovieName(name);
    }
    //POST
    @PostMapping("/createmovie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie postMovie(@RequestBody Movie movie) {
        System.out.println("indsætter ny movie!!");
        System.out.println(movie);
        return iMovieRepository.save(movie); //opda
    }

    //PUT
    @PutMapping("/updatemovie")
    public ResponseEntity<Movie> updateStudent(@RequestBody Movie movie) {
        Optional<Movie> orgMovie =iMovieRepository.findById(movie.getMovieId());
        if (orgMovie.isPresent()) {
            iMovieRepository.save(movie);
            return new ResponseEntity<>(movie, HttpStatus.OK); //body er JSON
        } else {
            return new ResponseEntity<>(new Movie(), HttpStatus.NOT_FOUND);
        }
    }






}
