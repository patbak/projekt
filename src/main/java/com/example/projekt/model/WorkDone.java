package com.example.projekt.model;


import javax.persistence.*;

@Entity
@Table(name = "wykonane_roboty")
public class WorkDone {

    @Id
    @GeneratedValue
    @Column(name = "id_wykonanej_roboty")
    private int WorkDoneId;

    @Column(name = "nazwa_wykonanej_roboty")
    private String WorkDoneName;

    @Column(name = "ilosc_robot")
    private float Quantity;

    @ManyToOne
    @JoinColumn(name = "raport_dzienny_brygady_id_raport_dzienny_brygady")
    private DailyWorkReport dailyWorkReport;

    @ManyToOne
    @JoinColumn(name = "ocena_jakosci_id_ocena_jakosci")
    private QualityAssessment qualityAssessment;

    @ManyToOne
    @JoinColumn(name = "roboty_id_roboty")
    private Work work;

    @ManyToOne
    @JoinColumn(name = "normy_pracy_id_normy_pracy")
    private LabourStandard labourStandard;

    public int getWorkDoneId() {
        return WorkDoneId;
    }

    public void setWorkDoneId(int workDoneId) {
        WorkDoneId = workDoneId;
    }

    public String getWorkDoneName() {
        return WorkDoneName;
    }

    public void setWorkDoneName(String workDoneName) {
        WorkDoneName = workDoneName;
    }

    public float getQuantity() {
        return Quantity;
    }

    public void setQuantity(float quantity) {
        Quantity = quantity;
    }

    public DailyWorkReport getDailyWorkReport() {
        return dailyWorkReport;
    }

    public void setDailyWorkReport(DailyWorkReport dailyWorkReport) {
        this.dailyWorkReport = dailyWorkReport;
    }

    public QualityAssessment getQualityAssessment() {
        return qualityAssessment;
    }

    public void setQualityAssessment(QualityAssessment qualityAssessment) {
        this.qualityAssessment = qualityAssessment;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public LabourStandard getLabourStandard() {
        return labourStandard;
    }

    public void setLabourStandard(LabourStandard labourStandard) {
        this.labourStandard = labourStandard;
    }
}
