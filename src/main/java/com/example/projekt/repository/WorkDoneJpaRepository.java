package com.example.projekt.repository;

import com.example.projekt.model.WorkDone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDoneJpaRepository extends JpaRepository<WorkDone, Integer> {

}
