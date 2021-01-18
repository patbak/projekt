package com.example.projekt.service;

import com.example.projekt.entity.LocalDateConverter;
import com.example.projekt.model.Employee;
import com.example.projekt.model.Hours;
import com.example.projekt.model.Timesheet;
import com.example.projekt.repository.EmployeeJpaRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.abs;

public class WorktimeService {// oblicza czas pracy dla każdego pracownika w poszczególnym miesiacu

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;
    private List<Hours>hoursList;

    private TimesheetService timesheetService;
    LocalDate localDate = LocalDate.parse("2012-05-22");

    LocalDateConverter localDateConverter = new LocalDateConverter();
    Date date = localDateConverter.convertToDatabaseColumn(localDate);

    public void getTimesheetsToCount(){//wybiera karty pracy dla każdego pracownika z poprzedniego miesiąca
        List<Employee> employees = employeeJpaRepository.findAll();
        List<Timesheet> timesheets = new ArrayList<>();
        for(int i=0;i<employees.size();i++){
            timesheets = timesheetService.getLastMonthTimesheets(
                    employees.get(i).getEmployeeId()
            );

            counWorkTime(timesheets);

        }
    }

    public void counWorkTime(List<Timesheet> timesheets ){

        Hours hours = new Hours();
        for (int i =0; i<timesheets.size(); i++){
        //dla każdej karty pracy będzie obliczać ilość godzin które upłynęły w pracy
        Timesheet timesheet = timesheets.get(i);
        LocalTime startOfWork = timesheet.getStartTimeOfWork();
        LocalTime endOfWork = timesheet.getEndTimeOfWork();
        LocalDate reportDate = timesheet.getReportDate();
        LocalDateTime dateTime1 = LocalDateTime.of(reportDate,startOfWork);
        LocalDateTime dateTime2 = LocalDateTime.of(reportDate,endOfWork);
            if(endOfWork.isBefore(startOfWork)){
                dateTime2=dateTime2.plusDays(1);
            }
        hours.addHours(countHours(dateTime1,dateTime2));
        hours.addOvertime(countOvertime(dateTime1,dateTime2));
        hours.addHarmfulHours(timesheet.getHarmfulHours());
        }

    }

    public int countHours(LocalDateTime startOfWork, LocalDateTime endOfWork ){
        int hours=0;
        hours=(int) Duration.between(startOfWork,endOfWork).toHours();
        return hours;
    }
    public int countOvertime(LocalDateTime startOfWork, LocalDateTime endOfWork){
        int overtime=0;
        int worktime=(int) Duration.between(startOfWork,endOfWork).toHours();
        if(worktime>8)
            overtime=worktime-8;
        return overtime;

    }

    public int countNightHours(LocalDateTime startOfWork, LocalDateTime endOfWork){
        int nightHours=0;

    return 0;
    }


/*    public int getTimeInMinutes(LocalTime startOfWork, LocalTime endOfWork){
        //oblicza przepracowany czas w minutach
        if(startOfWork.compareTo(endOfWork)==1){
            long minutes = startOfWork.until(endOfWork, ChronoUnit.MINUTES);
            long result = 1440-abs(minutes);
           // System.out.println(result);
            return (int) result;
        }else{
            long minutes = startOfWork.until(endOfWork,ChronoUnit.MINUTES);
            return (int) minutes;
        }
    }*/

/*
    public void countOvertime(Hours hours){
        int minutes = hours.getMinutes();
    if (minutes>480){
        int overtime = minutes-480;
        hours.setOvertime(overtime);
    }
    }*/

/*
    public int countNightHours(LocalTime startOfWork, LocalTime  endOfWork){
        LocalTime startOfNightHours = LocalTime.parse("22:00:00");
        LocalTime endOfNightHours = LocalTime.parse("06:00:00");
        if(startOfWork.compareTo(startOfNightHours)==-1&&endOfWork.compareTo(endOfNightHours)==-1){
            //drugi przypadek
            int nightHours = 2;
           nightHours+=  LocalTime.MIDNIGHT.until(endOfWork,ChronoUnit.HOURS);
           return nightHours;

        }else if(startOfWork.compareTo(startOfNightHours)==1&&endOfWork.compareTo(endOfNightHours)==-1){
                int nightHours=24;
            nightHours+=  startOfWork.until(LocalTime.MIDNIGHT,ChronoUnit.HOURS);
            nightHours+= LocalTime.MIDNIGHT.until(endOfWork,ChronoUnit.HOURS);
            return nightHours;

        }else  if(startOfWork.compareTo(startOfNightHours)==-1&&endOfWork.compareTo(endOfNightHours)==1){
            //trzeci przypadek
            int nightHours=8;
            return nightHours;

        }else if(startOfWork.compareTo(startOfNightHours)==1&&endOfWork.compareTo(endOfNightHours)==1){
            //czwarty przypadek
            int nightHours=24;
            nightHours+=  startOfWork.until(LocalTime.MIDNIGHT,ChronoUnit.HOURS);
            nightHours+= LocalTime.MIDNIGHT.until(endOfNightHours,ChronoUnit.HOURS);
            return nightHours;
        }
        return 0;
    }
*/



}
