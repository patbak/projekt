package com.example.projekt.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "uzytkownicy")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uzytkownika")
    private int userId;

    @Column(name = "imie")
    private String name;


    @Column(name = "nazwisko")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "haslo")
    private String password;

    @Column(name = "numer_telefonu")
    private String phoneNumber;

    @Column(name = "czy_kierownik")
    private boolean  isSupervisor;

/*    public User(String name, String lastName, String email, String login, String password, String phoneNumber, boolean isSupervisor){
        this.name=name;
        this.lastName=lastName;
        this.email=email;
        this.login=login;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.isSupervisor=isSupervisor;
    }*/

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<ConstructionSite> constructionSites;

    public List<ConstructionSite> getConstructionSites() {
        return constructionSites;
    }

    public void setConstructionSites(List<ConstructionSite> constructionSites) {
        this.constructionSites = constructionSites;
    }

    public List<DailyWorkReport> getDailyWorkReports() {
        return dailyWorkReports;
    }

    public void setDailyWorkReports(List<DailyWorkReport> dailyWorkReports) {
        this.dailyWorkReports = dailyWorkReports;
    }

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<DailyWorkReport> dailyWorkReports;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSupervisor() {
        return isSupervisor;
    }

    public void setSupervisor(boolean supervisor) {
        isSupervisor = supervisor;
    }
}
