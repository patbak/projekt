package com.example.projekt.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "raport_dzienny_brygady")
public class DailyWorkReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_raport_dzienny_brygady")
    private int DailyWorkReportId;

    @Column(name = "data")
    private Date reportDate;

    @Column(name = "warunki_pogodowe")
    private String weatherConditions;


    @ManyToOne
    @JoinColumn(name = "uzytkownicy_id_uzytkownika")
     private User user;

    @ManyToOne
    @JoinColumn(name = "budowa_id_budowy")
    private ConstructionSite constructionSite;


    @OneToMany(
            mappedBy = "dailyWorkReport",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<UsedMaterial> usedMaterials;

    @OneToMany
    private  List<DailyWorkReport> dailyWorkReports;

    @ManyToOne
    @JoinColumn(name = "brygadzisci_id_brygadzisty")
    private Foreman foreman;

    @OneToMany(
            mappedBy = "dailyWorkReport",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Timesheet> timesheets;

    public List<DailyWorkReport> getDailyWorkReports() {
        return dailyWorkReports;
    }

    public void setDailyWorkReports(List<DailyWorkReport> dailyWorkReports) {
        this.dailyWorkReports = dailyWorkReports;
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

    public int getDailyWorkReportId() {
        return DailyWorkReportId;
    }

    public void setDailyWorkReportId(int dailyWorkReportId) {
        DailyWorkReportId = dailyWorkReportId;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(String weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ConstructionSite getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(ConstructionSite constructionSite) {
        this.constructionSite = constructionSite;
    }

    public List<UsedMaterial> getUsedMaterials() {
        return usedMaterials;
    }

    public void setUsedMaterials(List<UsedMaterial> usedMaterials) {
        this.usedMaterials = usedMaterials;
    }
}
