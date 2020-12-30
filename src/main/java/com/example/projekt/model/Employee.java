package com.example.projekt.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pracownicy")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pracownika")
    private int employeeId;

    @Column(name = "imie")
    private String employeeName;

    @Column(name = "nazwisko")
    private String employeeLastName;

    @Column(name = "stawka_godzinowa")
    private float hourlyRate;

    @ManyToOne
    @JoinColumn(name = "brygadzisci_id_brygadzisty")
    private Foreman foreman;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Timesheet> timesheets;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<EmployeeQualification> employeeQualifications;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<DailyMachineWorkReport> dailyMachineWorkReports;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Foreman getForeman() {
        return foreman;
    }

    public void setForeman(Foreman foreman) {
        this.foreman = foreman;
    }

    public List<Timesheet> getTimesheets() {
        return timesheets;
    }

    public void setTimesheets(List<Timesheet> timesheets) {
        this.timesheets = timesheets;
    }

    public List<EmployeeQualification> getEmployeeQualifications() {
        return employeeQualifications;
    }

    public void setEmployeeQualifications(List<EmployeeQualification> employeeQualifications) {
        this.employeeQualifications = employeeQualifications;
    }

    public List<DailyMachineWorkReport> getDailyMachineWorkReports() {
        return dailyMachineWorkReports;
    }

    public void setDailyMachineWorkReports(List<DailyMachineWorkReport> dailyMachineWorkReports) {
        this.dailyMachineWorkReports = dailyMachineWorkReports;
    }
}
