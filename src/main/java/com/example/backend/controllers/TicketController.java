package com.example.backend.controllers;

import com.example.backend.model.Movie;
import com.example.backend.model.MoviePlan;
import com.example.backend.model.Ticket;
import com.example.backend.repositories.IMoviePlanRepository;
import com.example.backend.repositories.ITicketRepository;
import com.example.backend.service.TicketService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final ITicketRepository ticketRepository;
    private final IMoviePlanRepository moviePlanRepository;

    public TicketController(TicketService ticketService, ITicketRepository ticketRepository, IMoviePlanRepository moviePlanRepository) {
        this.ticketService = ticketService;
        this.ticketRepository = ticketRepository;
        this.moviePlanRepository = moviePlanRepository;
    }

    // GET: Hent alle billetter
    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }





}
