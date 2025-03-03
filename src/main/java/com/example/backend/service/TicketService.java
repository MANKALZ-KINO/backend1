package com.example.backend.service;

import com.example.backend.repositories.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final ITicketRepository iTicketRepository;

    @Autowired
    public TicketService(ITicketRepository iTicketRepository) {
        this.iTicketRepository = iTicketRepository;
    }
}
