package com.example.projekt.model;

import com.example.projekt.repository.QualityAssessmentJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class QualityAssessmentTest {

    @Autowired
    private QualityAssessmentJpaRepository qualityAssessmentJpaRepository;

    @Test
    @Transactional
    public void testGetOne(){
        QualityAssessment qualityAssessment = qualityAssessmentJpaRepository.getOne(1);

        assertTrue(qualityAssessment.getQualityAssessmentName().equals("test"));

        WorkDone workDone = qualityAssessment.getWorksDone().get(0);

        System.out.println( "\nOcena numer: " + qualityAssessment.getQualityAssessmentId()
                            +" Nazwa:  " + qualityAssessment.getQualityAssessmentName()
                            +" Wartość: " + qualityAssessment.getValue()
                            +" Robota: " + workDone.getWorkDoneName() + "\n") ;
    }

}
