package com.example.projekt.model;


import com.example.projekt.repository.DailyMachineWorkReportJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DailyMachineWorkReportTest {
    @Autowired
    private DailyMachineWorkReportJpaRepository dailyMachineWorkReportJpaRepository;

    @Test
    @Transactional
    public void testJpaFind(){
        DailyMachineWorkReport dailyMachineWorkReport = dailyMachineWorkReportJpaRepository.getOne(1);

        assertTrue(dailyMachineWorkReport.getReportNumber().equals("1234567"));

        System.out.print("Raport nr: " + dailyMachineWorkReport.getReportNumber()
                +" zadanie: "+ dailyMachineWorkReport.getTask()
                +" data: " + dailyMachineWorkReport.getReportDate()
                +" warunki pogodowe :" + dailyMachineWorkReport.getWeatherConditions()
        );

    }
}
