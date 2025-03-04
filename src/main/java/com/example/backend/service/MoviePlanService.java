package com.example.backend.service;

import com.example.backend.model.MoviePlan;
import com.example.backend.repositories.IMoviePlanRepository;
import com.example.backend.repositories.IMovieRepository;
import com.example.backend.repositories.ITicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MoviePlanService {

    @Autowired
    IMoviePlanRepository iMoviePlanRepository;

    @Autowired
    ITicketRepository iTicketRepository;

    @Transactional
    public void deleteMoviePlan(Long moviePlanId) {
        Optional<MoviePlan> moviePlanOpt = iMoviePlanRepository.findById(moviePlanId);

        if (moviePlanOpt.isPresent()) {
            MoviePlan moviePlan = moviePlanOpt.get();
            iTicketRepository.deleteAll(moviePlan.getTickets()); // Slet først tickets
            iMoviePlanRepository.delete(moviePlan); // Slet derefter MoviePlan
        } else {
            System.out.println("MoviePlan med ID " + moviePlanId + " blev ikke fundet. Springes over.");
        }
    }
}
