package com.example.projekt.model;


import com.example.projekt.entity.LocalDateConverter;
import com.example.projekt.repository.TimesheetJpaRepository;
import com.example.projekt.service.TimesheetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import static java.lang.StrictMath.abs;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TimesheetTest {

    @Autowired
    private TimesheetJpaRepository timesheetJpaRepository;
    @Autowired
    private TimesheetService timesheetService;

    @Test
    public void testFindAll(){
       List<Timesheet> timesheets = timesheetJpaRepository.findAll();

        assertTrue(timesheets.size()>0);

        Timesheet timesheet = timesheets.get(8);

        Employee employee = timesheet.getEmployee();

        DailyWorkReport dailyWorkReport = timesheet.getDailyWorkReport();

        System.out.println("\nKarta pracy numer: " + timesheet.getTimesheetId()
                            +" data karty pracy: " + dailyWorkReport.getReportDate()
                            +" pracownik:  " + employee.getEmployeeName() + " "
                            +employee.getEmployeeLastName()
                            +" godzina rozpoczęcia pracy: " + timesheet.getStartTimeOfWork()
                            +" godzina zakończenia pracy: " + timesheet.getEndTimeOfWork() +"\n" );
        LocalTime start = timesheet.getStartTimeOfWork();
        LocalTime end = timesheet.getEndTimeOfWork();
     //  long result = start.until(end, ChronoUnit.MINUTES);
        LocalTime nightHours = LocalTime.parse("22:00:00");
        System.out.println(timesheet.getHarmfulHours());
        System.out.println(nightHours);
        if(start.compareTo(end)==1){
            long minutes = start.until(end, ChronoUnit.MINUTES);
      long result = 1440-abs(minutes);
            System.out.println(result);
        }

    }

    @Test
    @Transactional
    public void testJpaGetTimesheetsByDate(){

    LocalTime startOfWork = LocalTime.parse("21:00:00");
    LocalTime endOfWork = LocalTime.parse("07:00:00");

        int nightHours=2;
        nightHours+=  startOfWork.until(LocalTime.MIDNIGHT,ChronoUnit.HOURS);
        nightHours+= LocalTime.MIDNIGHT.until(endOfWork,ChronoUnit.HOURS);
        System.out.println(startOfWork.isBefore(endOfWork));
        System.out.println(startOfWork.isAfter(endOfWork));
        System.out.println(nightHours);


       // List<Timesheet> timesheets = timesheetService.getTimesheetsByDate(2);


      //  List<Timesheet> timesheets = timesheetService.getTimesheetsByDate(date, 3);
/*


        for (int i =0; i<timesheets.size(); i++){

            System.out.println(timesheets.get(i).getTimesheetId());
            System.out.println(timesheets.get(i).getReportDate());

        }

        assertTrue(timesheets.size()>0);
*/



    }
/*    @Test
    @Transactional
    public void countNightHours(){
        LocalTime startOfWork = LocalTime.parse("17:00:00");
        LocalTime  endOfWork = LocalTime.parse("23:00:00");
        LocalTime startOfNightHours = LocalTime.parse("22:00:00");
        LocalTime endOfNightHours = LocalTime.parse("06:00:00");
        LocalTime eveningHour = LocalTime.parse("18:00:00");
        int nightHours = 0;
        if(startOfWork.compareTo(startOfNightHours)==-1&&endOfWork.compareTo(endOfNightHours)==-1){
            //drugi przypadek
            nightHours = 2;
            nightHours+=  LocalTime.MIDNIGHT.until(endOfWork,ChronoUnit.HOURS);
            //return nightHours;

        }else if(startOfWork.compareTo(startOfNightHours)==1&&endOfWork.compareTo(endOfNightHours)==-1){
             nightHours=24;
            nightHours+=  startOfWork.until(LocalTime.MIDNIGHT,ChronoUnit.HOURS);
            nightHours+= LocalTime.MIDNIGHT.until(endOfWork,ChronoUnit.HOURS);
          //  return nightHours;

        }else  if(startOfWork.compareTo(startOfNightHours)==-1&&endOfWork.compareTo(endOfNightHours)==1&&startOfWork.isAfter(eveningHour)){
            //trzeci przypadek
             nightHours=8;
           // return nightHours;

        }else if(startOfWork.compareTo(startOfNightHours)==1&&endOfWork.compareTo(endOfNightHours)==1){
            //czwarty przypadek
           nightHours=24;
            nightHours+=  startOfWork.until(LocalTime.MIDNIGHT,ChronoUnit.HOURS);
            nightHours+= LocalTime.MIDNIGHT.until(endOfNightHours,ChronoUnit.HOURS);
           // return nightHours;
        }
     System.out.println(nightHours);
    }*/
    @Test
    @Transactional
    public void timeTest(){
        LocalDateConverter localDateConverter = new LocalDateConverter();
        Timesheet timesheet = timesheetJpaRepository.getOne(9);
   /*     LocalTime localTime1 = timesheet.getStartTimeOfWork();
       LocalTime localTime2 = timesheet.getEndTimeOfWork();
        LocalDate date = timesheet.getReportDate();
       System.out.println(localTime1);
       System.out.println(localTime2);
       LocalDateTime dt1 = LocalDateTime.of(date, localTime1);
       LocalDateTime dt2 = LocalDateTime.of(date, localTime2);
     dt2=dt2.plusDays(1);
        System.out.println(dt1);
        System.out.println(dt2.plusDays(1));
        System.out.println(Duration.between(dt1,dt2).toHours());*/
        LocalTime startOfWork = timesheet.getStartTimeOfWork();
        LocalTime endOfWork = timesheet.getEndTimeOfWork();
        LocalDate reportDate = timesheet.getReportDate();
        LocalDateTime dateTime1 = LocalDateTime.of(reportDate,startOfWork);
        LocalDateTime dateTime2 = LocalDateTime.of(reportDate,endOfWork);
        if(endOfWork.isBefore(startOfWork)){
            dateTime2=dateTime2.plusDays(1);
        }
        System.out.println(dateTime1);
        System.out.println(dateTime2);


     //   LocalDate Date1 = timesheet.getReportDate();


    }

    @Test
    @Transactional
    public void countHoursTest( ){
        LocalDateTime startOfWork = LocalDateTime.parse("2020-12-20T22:00");
        LocalDateTime endOfWork = LocalDateTime.parse("2020-12-21T06:00");
        int hours=0;
        hours=(int) Duration.between(startOfWork,endOfWork).toHours();
        System.out.println(hours);

    }

    @Test
    @Transactional
    public void countOvertimeTest( ){
        LocalDateTime startOfWork = LocalDateTime.parse("2020-12-20T20:00");
        LocalDateTime endOfWork = LocalDateTime.parse("2020-12-21T06:00");
        int overtime=0;
        int worktime=(int) Duration.between(startOfWork,endOfWork).toHours();
        if(worktime>8)
            overtime=worktime-8;
      System.out.println(overtime);

    }
    @Test
    @Transactional
    public void countNightHours( ){
        LocalDateTime startOfWork = LocalDateTime.parse("2020-12-20T20:00");
        LocalDateTime endOfWork = LocalDateTime.parse("2020-12-21T06:00");
        LocalDate date = startOfWork.toLocalDate();
        System.out.println(date);
       // System.out.println( Duration.between(startOfWork,time1).toHours());

    }

}

