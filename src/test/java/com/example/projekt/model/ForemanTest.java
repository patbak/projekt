package com.example.projekt.model;


import com.example.projekt.repository.ForemanJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ForemanTest {

    @Autowired
    private ForemanJpaRepository foremanJpaRepository;

    @Test
    @Transactional
    public void testForemanGetOne() throws Exception{
        Foreman foreman = foremanJpaRepository.getOne(1);



        Employee employee = foreman.getEmployees().get(0);
        DailyWorkReport dailyWorkReport =  foreman.getDailyWorkReports().get(0);
        assertTrue(employee.getEmployeeName().equals("Patryk"));

        System.out.print("Brygadzista: "+ employee.getEmployeeName()
                            + " " + employee.getEmployeeLastName()
                            + " " + foreman.getCashAllowance()
                            + " " + dailyWorkReport.getReportDate() + "\n");
    }

}
