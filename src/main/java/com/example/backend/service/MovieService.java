package com.example.backend.service;

import com.example.backend.repositories.IMovieRepository;
import com.example.backend.repositories.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final IMovieRepository iMovieRepository;

    @Autowired
    public MovieService(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }
}
