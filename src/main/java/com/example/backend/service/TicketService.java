package com.example.backend.service;

import com.example.backend.model.MoviePlan;
import com.example.backend.model.Ticket;
import com.example.backend.repositories.IMoviePlanRepository;
import com.example.backend.repositories.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TicketService {

    private final ITicketRepository ticketRepository;
    private final IMoviePlanRepository moviePlanRepository;

    public TicketService(ITicketRepository iTicketRepository, IMoviePlanRepository moviePlanRepository) {
        this.ticketRepository = iTicketRepository;
        this.moviePlanRepository = moviePlanRepository;
    }

    //ved ikke om denne skal bruges
    public int displayAgeWithinLimit(Ticket ticket) {
        int ageLimit = ticket.getMoviePlan().getMovie().getAgeLimit();
        return ageLimit;
    }


    //* public boolean isSeatAvailable(int seatId) {
    // return ticketRepository.findBySeatID(seatId).isEmpty();
    //}//*


}
