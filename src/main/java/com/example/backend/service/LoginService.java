package com.example.backend.service;

import com.example.backend.model.Employee;
import com.example.backend.repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private static final IEmployeeRepository employeeRepository;
    private static final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(IEmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static boolean login(String username, String password) {
        String encodedPassword = null;
        try {
            encodedPassword = employeeRepository.findEncodedPasswordByUsername(username);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

        return passwordEncoder.matches(password, encodedPassword);
    }

    public Employee readUserProfile(String username) {
        return Employee.readUserProfile(username);
    }
}
