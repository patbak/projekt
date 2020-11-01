package com.example.projekt.repository;

import com.example.projekt.model.QualityAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityAssessmentJpaRepository  extends JpaRepository<QualityAssessment, Integer>{
}
