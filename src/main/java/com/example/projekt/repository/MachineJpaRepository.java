package com.example.projekt.repository;

import com.example.projekt.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineJpaRepository extends JpaRepository<Machine, Integer> {
}
