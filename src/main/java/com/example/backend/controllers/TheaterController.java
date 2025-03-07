package com.example.backend.controllers;

import com.example.backend.model.MoviePlan;
import com.example.backend.model.Theater;
import com.example.backend.repositories.ITheaterRepository;
import com.example.backend.service.TheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    private final TheaterService theaterService;


    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    // GET: Hent alle
    @GetMapping("/all")
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheathers();
    }

    @GetMapping("/{id}")
    public List<Theater> theaterById(@PathVariable Long id) {
        return theaterService.findTheatherById(id);
    }




}
