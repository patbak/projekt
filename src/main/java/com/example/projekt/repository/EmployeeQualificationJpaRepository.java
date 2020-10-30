package com.example.projekt.repository;

import com.example.projekt.model.EmployeeQualification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeQualificationJpaRepository extends JpaRepository<EmployeeQualification, Integer> {
}
