package com.example.projekt.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "uprawnienia")
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uprawnienia")
    private int QualificationId;

    @Column(name = "nazwa")
    private String QualificationName;

    @OneToMany(
            mappedBy = "qualification",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<EmployeeQualification> employeeQualifications;

    public int getQualificationId() {
        return QualificationId;
    }

    public void setQualificationId(int qualificationId) {
        QualificationId = qualificationId;
    }

    public String getQualificationName() {
        return QualificationName;
    }

    public void setQualificationName(String qualificationName) {
        QualificationName = qualificationName;
    }

    public List<EmployeeQualification> getEmployeeQualifications() {
        return employeeQualifications;
    }

    public void setEmployeeQualifications(List<EmployeeQualification> employeeQualifications) {
        this.employeeQualifications = employeeQualifications;
    }
}
