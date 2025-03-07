package com.example.backend.service;

import com.example.backend.model.Theater;
import com.example.backend.repositories.ITheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    ITheaterRepository iTheaterRepository;

    public TheaterService(ITheaterRepository iTheaterRepository) {
        this.iTheaterRepository = iTheaterRepository;
    }

    public List<Theater> getAllTheathers() {
        return iTheaterRepository.findAll();
    }
    public List<Theater> findTheatherById(Long id) {
        return iTheaterRepository.findByTheaterId(id);
    }

}
