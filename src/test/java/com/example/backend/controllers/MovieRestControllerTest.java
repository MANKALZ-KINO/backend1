package com.example.backend.controllers;

import com.example.backend.model.Movie;
import com.example.backend.repositories.IMovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MovieRestControllerTest {

    @Autowired
    IMovieRepository iMovieRepository;

    @Test
    void findAllbyName(){
        List<Movie> list = iMovieRepository.findAllBymovieName("Titanic");
        assertEquals(1, list.size());
    }

}