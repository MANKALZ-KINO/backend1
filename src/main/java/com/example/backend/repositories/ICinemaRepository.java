package com.example.backend.repositories;

import com.example.backend.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICinemaRepository extends JpaRepository<Cinema,Long> {
}
