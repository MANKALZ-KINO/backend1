package com.example.backend.service;

import com.example.backend.model.MoviePlan;
import com.example.backend.model.Ticket;
import com.example.backend.repositories.IMoviePlanRepository;
import com.example.backend.repositories.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    private final ITicketRepository ticketRepository;
    private final IMoviePlanRepository moviePlanRepository;

    public TicketService(ITicketRepository iTicketRepository, IMoviePlanRepository moviePlanRepository) {
        this.ticketRepository = iTicketRepository;
        this.moviePlanRepository = moviePlanRepository;
    }



}
