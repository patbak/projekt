package com.example.projekt.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "uprawnienia_pracownikow")
public class EmployeeQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uprawnienia_pracownikow")
    private int EmployeeQualificationId;

    @ManyToOne
    @JoinColumn(name = "uprawnienia_id_uprawnienia")
    private Qualification qualification;

    @ManyToOne
    @JoinColumn(name = "pracownicy_id_pracownika")
    private Employee employee;

    public int getEmployeeQualificationId() {
        return EmployeeQualificationId;
    }

    public void setEmployeeQualificationId(int employeeQualificationId) {
        EmployeeQualificationId = employeeQualificationId;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
