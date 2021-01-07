package com.example.projekt.service;

import com.example.projekt.model.Employee;
import com.example.projekt.model.Timesheet;
import com.example.projekt.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SalaryService {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public void getTimesheetsToCount(){
        List<Employee> employees = employeeJpaRepository.findAll();
        List<Timesheet> timesheets = new ArrayList<>();
        for(int i=0;i<employees.size();i++){
            timesheets = employees.get(i).getTimesheets();
        }
    }

    public void countHours(List<Timesheet> timesheets ){
        for (int i =0; i<timesheets.size(); i++){
            
        }
    }

}
