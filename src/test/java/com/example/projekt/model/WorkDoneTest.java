package com.example.projekt.model;

import com.example.projekt.repository.WorkDoneJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class WorkDoneTest {

    @Autowired
    private WorkDoneJpaRepository workDoneJpaRepository;

    @Test
    public void testFindAll(){

        List<WorkDone> worksDone = workDoneJpaRepository.findAll();

        assertTrue(worksDone.size()>0);

        WorkDone workDone = worksDone.get(0);

        DailyWorkReport dailyWorkReport = workDone.getDailyWorkReport();

        System.out.println("\nNazwa wykonanej roboty: " + workDone.getWorkDoneName()
                            +" Ilość robót: " + workDone.getQuantity()
                            +" Data: " + dailyWorkReport.getReportDate()
                            +" Warunki pogodowe: " + dailyWorkReport.getWeatherConditions()+"\n");
    }

}
