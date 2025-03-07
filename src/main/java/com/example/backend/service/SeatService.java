package com.example.backend.service;

import com.example.backend.repositories.ISeatRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    private ISeatRepository iSeatRepository;

    public SeatService(ISeatRepository iSeatRepository) {
        this.iSeatRepository = iSeatRepository;
    }

    public void findAvaliableSeat() {

    }
}
