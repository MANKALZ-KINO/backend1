package com.example.backend.controllers;

import com.example.backend.model.Employee;
import com.example.backend.model.Movie;
import com.example.backend.repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    //GET
    @GetMapping("/employees")
    public List<Employee> movies() {
        return iEmployeeRepository.findAll();
    }
    @GetMapping("/employee/{name}") public List<Employee> allEmployeesByName(@PathVariable String name) {
        return iEmployeeRepository.findByNameIgnoreCase(name);
    }

}
