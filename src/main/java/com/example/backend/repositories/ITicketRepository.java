package com.example.backend.repositories;

import com.example.backend.model.Movie;
import com.example.backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findBySeatID(int seatID);

}
