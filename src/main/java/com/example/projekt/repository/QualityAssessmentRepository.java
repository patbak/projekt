package com.example.projekt.repository;

import com.example.projekt.model.QualityAssessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QualityAssessmentRepository {

    @Autowired
    private QualityAssessmentJpaRepository qualityAssessmentJpaRepository;

    public QualityAssessment create(QualityAssessment qualityAssessment){
        return qualityAssessmentJpaRepository.saveAndFlush(qualityAssessment);
    }

    public QualityAssessment update(QualityAssessment qualityAssessment){
        return  qualityAssessmentJpaRepository.saveAndFlush(qualityAssessment);
    }

    public void delete(int id){
        qualityAssessmentJpaRepository.deleteById(id);
    }

    public QualityAssessment find(int id){
        return qualityAssessmentJpaRepository.getOne(id);
    }

}
