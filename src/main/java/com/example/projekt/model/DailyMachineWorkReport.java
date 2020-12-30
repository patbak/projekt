package com.example.projekt.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "raport_dzienny_pracy_sprzetu")
public class DailyMachineWorkReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_raportu_dziennego_pracy_sprzetu")
    private int DailyMachineWorkReportId;

    @Column(name = "numer_raportu")
    private String reportNumber;

    @Column(name = "data")
    private Date reportDate;

    @Column(name = "zadanie")
    private String task;

    @Column(name = "warunki_pogodowe")
    private String weatherConditions;

    @Column(name = "uwagi")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "maszyny_id_maszyny")
    private Machine machine;

    @ManyToOne
    @JoinColumn(name = "pracownicy_id_pracownika")
    private Employee employee;


    public int getDailyMachineWorkReportId() {
        return DailyMachineWorkReportId;
    }

    public void setDailyMachineWorkReportId(int dailyMachineWorkReportId) {
        DailyMachineWorkReportId = dailyMachineWorkReportId;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(String weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
