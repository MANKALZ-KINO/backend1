package com.example.backend.repositories;

import com.example.backend.model.Movie;
import com.example.backend.model.MoviePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface IMoviePlanRepository extends JpaRepository<MoviePlan,Long> {


    List<MoviePlan> getMoviePlanByDate(LocalDate date);
}
