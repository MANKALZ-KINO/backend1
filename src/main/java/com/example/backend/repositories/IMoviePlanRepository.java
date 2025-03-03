package com.example.backend.repositories;

import com.example.backend.model.MoviePlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMoviePlanRepository extends JpaRepository<MoviePlan,Long> {
}
