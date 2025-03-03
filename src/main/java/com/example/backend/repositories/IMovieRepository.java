package com.example.backend.repositories;

import com.example.backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllBymovieName(String movieName);
}
