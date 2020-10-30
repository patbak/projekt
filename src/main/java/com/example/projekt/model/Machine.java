package com.example.projekt.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "maszyny")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_maszyny")
    private int machineId;

    @Column(name = "nazwa")
    private String machineName;

    @Column(name = "numer_inwentarzowy")
    private String inventoryNumber;

    @Column(name = "moc_km")
    private  int powerHP;

    @Column(name = "zuzycie_paliwa")
    private float fuelConsumption;

    @Column(name = "pojemnosc_zbiornika_paliwa")
    private int fuelTankCapacity;

    @Column(name = "rok_produkcji")
    private Date  yearOfProduction;

    @Column(name = "uwagi")
    private String comments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "machine")
    private List<DailyMachineWorkReport> dailyMachineWorkReports;

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public int getPowerHP() {
        return powerHP;
    }

    public void setPowerHP(int powerHP) {
        this.powerHP = powerHP;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(int fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public Date getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Date yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<DailyMachineWorkReport> getDailyMachineWorkReports() {
        return dailyMachineWorkReports;
    }

    public void setDailyMachineWorkReports(List<DailyMachineWorkReport> dailyMachineWorkReports) {
        this.dailyMachineWorkReports = dailyMachineWorkReports;
    }
}
