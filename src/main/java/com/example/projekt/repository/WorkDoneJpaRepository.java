package com.example.projekt.repository;

import com.example.projekt.model.WorkDone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkDoneJpaRepository extends JpaRepository<WorkDone, Integer> {

}
