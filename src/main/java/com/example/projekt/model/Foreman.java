package com.example.projekt.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brygadzisci")
public class Foreman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brygadzisty")
    private int foremanId;

    @Column(name = "dodatek")
    private float cashAllowance;

    @OneToMany(
            mappedBy = "foreman",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Employee> employees;

    @OneToMany(
            mappedBy = "foreman",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<DailyWorkReport> dailyWorkReports;

    public int getForemanId() {
        return foremanId;
    }

    public void setForemanId(int foremanId) {
        this.foremanId = foremanId;
    }

    public float getCashAllowance() {
        return cashAllowance;
    }

    public void setCashAllowance(float cashAllowance) {
        this.cashAllowance = cashAllowance;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<DailyWorkReport> getDailyWorkReports() {
        return dailyWorkReports;
    }

    public void setDailyWorkReports(List<DailyWorkReport> dailyWorkReports) {
        this.dailyWorkReports = dailyWorkReports;
    }
}
