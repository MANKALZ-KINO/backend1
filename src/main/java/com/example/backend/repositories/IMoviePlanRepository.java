package com.example.backend.repositories;

import com.example.backend.model.Movie;
import com.example.backend.model.MoviePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMoviePlanRepository extends JpaRepository<MoviePlan,Long> {
}
