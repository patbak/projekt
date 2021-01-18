package com.example.projekt.model;

public class Salary {

    private double overtimeSalary;
    private double harmfulHoursSalary;
    private double nightHoursSalary;
    private double hoursSalary;

    public void Salary(
            double hoursSalary,
            double overtimeSalary,
            double harmfulHoursSalary,
            double nightHoursSalary
            ){
        this.hoursSalary=hoursSalary;
        this.overtimeSalary=overtimeSalary;
        this.nightHoursSalary=nightHoursSalary;
        this.harmfulHoursSalary=harmfulHoursSalary;
    }

    public double getOvertimeSalary() {
        return overtimeSalary;
    }

    public void setOvertimeSalary(double overtimeSalary) {
        this.overtimeSalary = overtimeSalary;
    }

    public double getHarmfulHoursSalary() {
        return harmfulHoursSalary;
    }

    public void setHarmfulHoursSalary(double harmfulHoursSalary) {
        this.harmfulHoursSalary = harmfulHoursSalary;
    }

    public double getNightHoursSalary() {
        return nightHoursSalary;
    }

    public void setNightHoursSalary(double nightHoursSalary) {
        this.nightHoursSalary = nightHoursSalary;
    }

    public double getHoursSalary() {
        return hoursSalary;
    }

    public void setHoursSalary(double hoursSalary) {
        this.hoursSalary = hoursSalary;
    }
}
