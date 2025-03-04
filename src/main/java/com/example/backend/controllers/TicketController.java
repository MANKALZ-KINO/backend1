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

    // GET: Hent alle
    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketRepository.save(ticket);
        return ResponseEntity.ok(savedTicket);
    }


    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable int id, @RequestBody Ticket updatedTicket) {
        if (!ticketRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedTicket.setTicketID(id); // Sikrer at ID'et bliver det samme
        Ticket savedTicket = ticketRepository.save(updatedTicket);
        return ResponseEntity.ok(savedTicket);
    }

    //DELETE via id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable int id) {
        if (!ticketRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ticketRepository.deleteById(id);
        return ResponseEntity.ok("Ticket deleted successfully");
    }


}
