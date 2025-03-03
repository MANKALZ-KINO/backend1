package com.example.backend.repositories;

import com.example.backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
}
