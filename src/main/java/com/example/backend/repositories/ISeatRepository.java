package com.example.backend.repositories;

import com.example.backend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeatRepository extends JpaRepository<Seat, Long> {
}
