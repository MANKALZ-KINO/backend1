package com.example.backend.config;

import com.example.backend.model.Seat;
import com.example.backend.model.Theater;
import com.example.backend.repositories.ISeatRepository;
import com.example.backend.repositories.ITheaterRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeatInitData implements CommandLineRunner {

    @Autowired
    ISeatRepository iSeatRepository;

    @Autowired
    ITheaterRepository iTheaterRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<Theater> theaters = iTheaterRepository.findAll();

        List<Seat> seats = new ArrayList<>();

        for (Theater theater : theaters) {
            Theater managedTheater = entityManager.merge(theater);
            int numRows;
            int numSeatsPerRow;

            if (managedTheater.getCapacity() <= 200) {
                numRows = 20;
                numSeatsPerRow = 12;
            } else {
                numRows = 25;
                numSeatsPerRow = 16;
            }

            for (int row = 1; row <= numRows; row++) {
                for (int seatNum = 1; seatNum <= numSeatsPerRow; seatNum++) {
                    Seat seat = new Seat();
                    seat.setRowNum(row);
                    seat.setSeatNumb(seatNum);
                    seat.setTheater(managedTheater);
                    seats.add(seat);
                }
            }
            System.out.println((numRows * numSeatsPerRow) + " seats added for Theater ID: " + managedTheater.getTheaterId());
        }

        iSeatRepository.saveAll(seats);
        System.out.println("All seats initialized successfully!");
    }
}

