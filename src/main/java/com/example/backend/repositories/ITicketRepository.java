package com.example.backend.repositories;

import com.example.backend.model.Movie;
import com.example.backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITicketRepository extends JpaRepository<Ticket, Integer> {
}
