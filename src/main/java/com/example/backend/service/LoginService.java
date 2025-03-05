package com.example.backend.service;

import com.example.backend.model.Employee;
import com.example.backend.repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private IEmployeeRepository employeeRepository;
    private final String PASSWORD = "admin123";


    public boolean authenticate(String name, String password) {
        Employee employee = employeeRepository.findByName(name);

        if (employee != null && password.equals(PASSWORD)) {
            return true;
        }

        return false;
    }
}
