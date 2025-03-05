package com.example.backend.service;

import com.example.backend.repositories.IMovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final IMovieRepository iMovieRepository;

    public MovieService(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }



}
