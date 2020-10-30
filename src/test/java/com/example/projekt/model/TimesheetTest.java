package com.example.projekt.model;


import com.example.projekt.repository.TimesheetJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TimesheetTest {

    @Autowired
    private TimesheetJpaRepository timesheetJpaRepository;

    @Test
    public void testFindAll(){
       List<Timesheet> timesheets = timesheetJpaRepository.findAll();

        assertTrue(timesheets.size()>0);

        Timesheet timesheet = timesheets.get(0);

        Employee employee = timesheet.getEmployee();

        DailyWorkReport dailyWorkReport = timesheet.getDailyWorkReport();

        System.out.println("\nKarta pracy numer: " + timesheet.getTimesheetId()
                            +" data karty pracy: " + dailyWorkReport.getReportDate()
                            +" pracownik:  " + employee.getEmployeeName() + " "
                            +employee.getEmployeeLastName()
                            +" godzina rozpoczęcia pracy: " + timesheet.getStartTimeOfWork()
                            +" godzina zakończenia pracy: " + timesheet.getEndTimeOfWork() +"\n" );

    }

}
