package com.example.projekt.repository;

import com.example.projekt.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineJpaRepository extends JpaRepository<Machine, Integer> {
}
