package com.example.projekt.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ocena_jakosci")
public class QualityAssessment {

    @Id
    @GeneratedValue
    @Column(name = "id_ocena_jakosci")
    private int qualityAssessmentId;

    @Column(name = "wartosc")
    private int value;

    @Column(name = "nazwa")
    private String qualityAssessmentName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "qualityAssessment")
    private List<WorkDone> worksDone;

    public List<WorkDone> getWorksDone() {
        return worksDone;
    }

    public void setWorksDone(List<WorkDone> worksDone) {
        this.worksDone = worksDone;
    }

    public int getQualityAssessmentId() {
        return qualityAssessmentId;
    }

    public void setQualityAssessmentId(int qualityAssessmentId) {
        this.qualityAssessmentId = qualityAssessmentId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getQualityAssessmentName() {
        return qualityAssessmentName;
    }

    public void setQualityAssessmentName(String qualityAssessmentName) {
        this.qualityAssessmentName = qualityAssessmentName;
    }




}
