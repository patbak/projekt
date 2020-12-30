package com.example.projekt.model;


import com.example.projekt.repository.ConstructionSiteJpaRepository;
import com.example.projekt.repository.DailyWorkReportJpaRepository;
import org.hibernate.Criteria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DailyWorkReportTest {

    @Autowired
    private DailyWorkReportJpaRepository dailyWorkReportJpaRepository;

    @Test
    @Transactional
    public void testJpaFindById(){

       DailyWorkReport dailyWorkReport = dailyWorkReportJpaRepository.getOne(1);
       ConstructionSite constructionSite = dailyWorkReport.getConstructionSite();
        System.out.println("\nRaport nr: "+dailyWorkReport.getDailyWorkReportId()
                +"\nData: "+dailyWorkReport.getReportDate()
                +"\nWarunki pogodowe: " +dailyWorkReport.getWeatherConditions()
                +"\nbudowa: "+constructionSite.getName()
                +"");

        assertTrue(dailyWorkReport!=null);
    }

}
