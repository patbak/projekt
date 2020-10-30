package com.example.projekt.repository;

import com.example.projekt.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public Employee create(Employee employee){
        return employeeJpaRepository.saveAndFlush(employee);
    }

    public Employee update(Employee employee){
        return employeeJpaRepository.saveAndFlush(employee);
    }

    public void delete(int id){
        employeeJpaRepository.deleteById(id);
    }

    public Employee find(int id){
        return employeeJpaRepository.getOne(id);
    }

}
