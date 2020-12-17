package com.example.projekt.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "budowa")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ConstructionSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_budowy")
    private int ConstructionSiteId;

    @Column(name = "nazwa")
    private String name;

    @Column(name = "opis")
    private String description;

    @Column(name = "wspolrzedne")
    private String coordinates;

    @Column(name = "planowana_data_rozpoczecia")
    private Date plannedStartDate;

    @Column(name = "planowana_data_zakonczenia")
    private Date plannedEndDate;

    @ManyToOne
    @JoinColumn(name = "uzytkownicy_id_uzytkownika")
    private   User user;

   @OneToMany
   private List<DailyWorkReport> dailyWorkReport;

    public List<DailyWorkReport> getDailyWorkReports() {
        return dailyWorkReport;
    }

    public void setDailyWorkReports(List<DailyWorkReport> dailyWorkReports) {
        this.dailyWorkReport = dailyWorkReports;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getConstructionSiteId() {
        return ConstructionSiteId;
    }

    public void setConstructionSiteId(int constructionSiteId) {
        ConstructionSiteId = constructionSiteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(Date plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }
}
