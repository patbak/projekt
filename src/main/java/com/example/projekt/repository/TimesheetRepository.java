package com.example.projekt.repository;

import com.example.projekt.model.Timesheet;
import org.springframework.beans.factory.annotation.Autowired;

public class TimesheetRepository {

    @Autowired
    private TimesheetJpaRepository timesheetJpaRepository;

    public Timesheet create(Timesheet timesheet){
        return timesheetJpaRepository.saveAndFlush(timesheet);
    }

    public Timesheet update(Timesheet timesheet){
        return timesheetJpaRepository.saveAndFlush(timesheet);
    }

    public void delete(int id){
        timesheetJpaRepository.deleteById(id);
    }

    public Timesheet find(int id){
       return timesheetJpaRepository.getOne(id);
    }

}
