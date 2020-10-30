package com.example.projekt.repository;


import com.example.projekt.model.EmployeeQualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeQualificationRepository {

    @Autowired
    private EmployeeQualificationJpaRepository employeeQualificationJpaRepository;

    public EmployeeQualification create(EmployeeQualification employeeQualification){
        return employeeQualificationJpaRepository.saveAndFlush(employeeQualification);
    }

    public EmployeeQualification update(EmployeeQualification employeeQualification){
        return  employeeQualificationJpaRepository.saveAndFlush(employeeQualification);
    }

    public void delete(int id){
        employeeQualificationJpaRepository.deleteById(id);
    }

    public EmployeeQualification find(int id){
        return  employeeQualificationJpaRepository.getOne(id);
    }

}
