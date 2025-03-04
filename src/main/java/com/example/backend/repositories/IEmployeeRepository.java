package com.example.backend.repositories;

import com.example.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
   List<Employee> findByNameIgnoreCase(String name);
}
