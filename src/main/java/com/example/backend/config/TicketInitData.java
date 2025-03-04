package com.example.backend.config;

import com.example.backend.model.Seat;
import com.example.backend.model.Ticket;
import com.example.backend.repositories.ISeatRepository;
import com.example.backend.repositories.ITicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TicketInitData implements CommandLineRunner {

    @Autowired
    ITicketRepository iTicketRepository;

    @Autowired
    ISeatRepository iSeatRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (iTicketRepository.count() == 0) {
            // Hent eksisterende sæder
            List<Seat> seats = iSeatRepository.findAll();

            if (seats.isEmpty()) {
                System.out.println("Der skal være mindst to sæder i databasen for at oprette billetter.");
                return;
            }

            if (seats.size() < 2) {
                System.out.println("Der skal være mindst to sæder i databasen for at oprette billetter.");
                return;
            }
            Ticket ticket1 = new Ticket();
            ticket1.setOrder_date(LocalDate.now());
            ticket1.setTicket_price(120.50);
            ticket1.setPhoneNumber(12345678);
            ticket1.setSeat(seats.get(0));

            Ticket ticket2 = new Ticket();
            ticket2.setOrder_date(LocalDate.now());
            ticket2.setTicket_price(99.99);
            ticket2.setPhoneNumber(87654321);
            ticket2.setSeat(seats.get(1));

            iTicketRepository.save(ticket1);
            iTicketRepository.save(ticket2);

        }
    }
}
