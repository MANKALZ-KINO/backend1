package com.example.backend.repositories;

import com.example.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e.encodedPassword FROM Employee e WHERE e.username = ?1")
    String findEncodedPasswordByUsername(String username);

}
