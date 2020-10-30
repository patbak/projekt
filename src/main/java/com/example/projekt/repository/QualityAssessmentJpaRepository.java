package com.example.projekt.repository;

import com.example.projekt.model.QualityAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualityAssessmentJpaRepository  extends JpaRepository<QualityAssessment, Integer>{
}
