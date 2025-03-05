package com.example.backend.controllers;

import com.example.backend.model.Movie;
import com.example.backend.repositories.IMovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
class MovieRestControllerTest {

    @Autowired
    IMovieRepository iMovieRepository;

    /*@Test
    void findAllbyName(){
        List<Movie> list = iMovieRepository.findAllBymovieName("Titanic");
        assertEquals(1, list.size());
    }*/
    @Test
    void findAllbyName(){
        // Insert test data into H2
        Movie movie = new Movie();
        movie.setGenre("Drama");
        movie.setMovieName("Titanic");
        movie.setAgeLimit(13);
        movie.setDuration(195);
        iMovieRepository.save(movie);

        List<Movie> list = iMovieRepository.findAllBymovieName("Titanic");
        assertEquals(1, list.size());
    }

}