package com.example.projekt.model;


import javax.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "karty_pracy")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_karty_pracy")
    private int TimesheetId;

    @Column(name = "godzina_rozpoczecia")
    private LocalTime startTimeOfWork;

    @Column(name = "godzina_zakonczenia")
    private LocalTime endTimeOfWork;

    @Column(name = "szkodliwe_godziny")
    private int harmfulHours;

    @Column(name = "data_karty_pracy")
    private LocalDate timesheetDate;


    @ManyToOne
    @JoinColumn(name = "raport_dzienny_brygady_id_raport_dzienny_brygady")
    private DailyWorkReport dailyWorkReport;

    @ManyToOne
    @JoinColumn(name = "pracownicy_id_pracownika")
    private Employee employee;

    public int getTimesheetId() {
        return TimesheetId;
    }

    public void setTimesheetId(int timesheetId) {
        TimesheetId = timesheetId;
    }

    public LocalTime getStartTimeOfWork() {
        return startTimeOfWork;
    }

    public void setStartTimeOfWork(LocalTime startTimeOfWork) {
        this.startTimeOfWork = startTimeOfWork;
    }

    public LocalTime getEndTimeOfWork() {
        return endTimeOfWork;
    }

    public void setEndTimeOfWork(LocalTime endTimeOfWork) {
        this.endTimeOfWork = endTimeOfWork;
    }

    public int getHarmfulHours() {
        return harmfulHours;
    }

    public void setHarmfulHours(int harmfulHours) {
        this.harmfulHours = harmfulHours;
    }

    public LocalDate getTimesheetDate() {
        return timesheetDate;
    }

    public void setTimesheetDate(LocalDate timesheetDate) {
        this.timesheetDate = timesheetDate;
    }

    public DailyWorkReport getDailyWorkReport() {
        return dailyWorkReport;
    }

    public void setDailyWorkReport(DailyWorkReport dailyWorkReport) {
        this.dailyWorkReport = dailyWorkReport;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
