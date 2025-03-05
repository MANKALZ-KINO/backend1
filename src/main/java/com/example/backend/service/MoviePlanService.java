package com.example.backend.service;

import com.example.backend.repositories.IMoviePlanRepository;
import com.example.backend.repositories.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviePlanService  {

    @Autowired
    IMoviePlanRepository iMoviePlanRepository;

    @Autowired
    ITicketRepository iTicketRepository;


}
