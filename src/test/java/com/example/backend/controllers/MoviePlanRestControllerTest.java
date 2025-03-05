/*package com.example.backend.controllers;

import com.example.backend.model.MoviePlan;
import com.example.backend.repositories.IMoviePlanRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MoviePlanRestControllerTest {

    @Autowired
    IMoviePlanRepository iMoviePlanRepository;

    @Test
    void moviePlans() {
    }
    @Test
    void findAllbyDate(){
        List<MoviePlan> list = iMoviePlanRepository.getMoviePlanByDate(LocalDate.of(2025, 3, 4));
        assertEquals(1, list.size());
    }

}*/