package com.example.projekt.model;


import com.example.projekt.repository.EmployeeQualificationJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class
EmployeeQualificationTest {

    @Autowired
    private EmployeeQualificationJpaRepository employeeQualificationJpaRepository;

    @Test
    @Transactional
    public void testEmployeeQualificationGetOne() throws Exception{
        EmployeeQualification employeeQualification = employeeQualificationJpaRepository.getOne(1);
        Employee employee = employeeQualification.getEmployee();
        Qualification qualification = employeeQualification.getQualification();
        assertTrue(employee.getEmployeeName().equals("Patryk"));

        System.out.print("Pracownik: "+employee.getEmployeeName() + " " + employee.getEmployeeLastName()+
                        " Uprawnienie: "+qualification.getQualificationName()+"\n");


    }


}
