package com.example.projekt.repository;

import com.example.projekt.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationJpaRepository extends JpaRepository<Qualification, Integer> {
}
