package com.example.backend.repositories;

import com.example.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
