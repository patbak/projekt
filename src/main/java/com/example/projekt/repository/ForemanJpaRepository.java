package com.example.projekt.repository;

import com.example.projekt.model.Foreman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForemanJpaRepository extends JpaRepository<Foreman,Integer> {
}
