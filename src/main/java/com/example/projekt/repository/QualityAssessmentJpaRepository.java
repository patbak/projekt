package com.example.projekt.repository;

import com.example.projekt.model.QualityAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "ocenaJakosci", collectionResourceRel = "ocenaJakosci")
public interface QualityAssessmentJpaRepository  extends JpaRepository<QualityAssessment, Integer>{
}
