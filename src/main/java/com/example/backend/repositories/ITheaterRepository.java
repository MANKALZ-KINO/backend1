package com.example.backend.repositories;

import com.example.backend.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITheaterRepository extends JpaRepository<Theater, Long> {
}
