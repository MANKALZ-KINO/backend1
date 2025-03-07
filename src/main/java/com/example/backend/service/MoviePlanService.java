package com.example.backend.service;

import com.example.backend.model.MoviePlan;
import com.example.backend.repositories.IMoviePlanRepository;
import com.example.backend.repositories.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviePlanService  {

    private IMoviePlanRepository iMoviePlanRepository;

    public MoviePlanService(IMoviePlanRepository iMoviePlanRepository) {
        this.iMoviePlanRepository = iMoviePlanRepository;
    }

    public List<MoviePlan> moviePlansWithMovieId(){
       return iMoviePlanRepository.findAll();
   }

   public Optional<MoviePlan> movieplans (Long id) {
     return iMoviePlanRepository.findById(id);
   }
  public void  deleteMovieById (Long id) {
       iMoviePlanRepository.deleteById(id);
   }

}
