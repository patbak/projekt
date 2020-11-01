package com.example.projekt.repository;

import com.example.projekt.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetJpaRepository extends JpaRepository<Timesheet, Integer> {
}
