package com.example.projekt.model;

public class Hours {

    private int minutes;
    private int hours;
    private int nightHours;
    private int harmfulHours;
    private int overtime;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getNightHours() {
        return nightHours;
    }

    public void setNightHours(int nightHours) {
        this.nightHours = nightHours;
    }

    public int getHarmfulHours() {
        return harmfulHours;
    }

    public void setHarmfulHours(int harmfulHours) {
        this.harmfulHours = harmfulHours;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public void  addHours(int hours){
        this.hours+=hours;
    }

    public  void addOvertime(int overtime){
        this.overtime+=overtime;
    }

    public  void addHarmfulHours(int harmfulHours){
        this.harmfulHours+=harmfulHours;
    }
}
