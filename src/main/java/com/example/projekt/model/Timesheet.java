package com.example.projekt.model;


import javax.persistence.*;

import java.sql.Time;


@Entity
@Table(name = "karty_pracy")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_karty_pracy")
    private int TimesheetId;

    @Column(name = "godzina_rozpoczecia")
    private Time startTimeOfWork;

    @Column(name = "godzina_zakonczenia")
    private Time endTimeOfWork;

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

    public Time getStartTimeOfWork() {
        return startTimeOfWork;
    }

    public void setStartTimeOfWork(Time startTimeOfWork) {
        this.startTimeOfWork = startTimeOfWork;
    }

    public Time getEndTimeOfWork() {
        return endTimeOfWork;
    }

    public void setEndTimeOfWork(Time endTimeOfWork) {
        this.endTimeOfWork = endTimeOfWork;
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
