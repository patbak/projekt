package com.example.projekt.model;


import com.example.projekt.repository.QualificationJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class QualificationTest {

    @Autowired
    private QualificationJpaRepository qualificationJpaRepository;

    @Test
    @Transactional
    public void testQualificationGetOne(){
        List<Qualification> qualifications = qualificationJpaRepository.findAll();
        Qualification qualification = qualifications.get(0);
        assertTrue(qualifications.size()>0);

        EmployeeQualification employeeQualification = qualifications.get(0).getEmployeeQualifications().get(0);
        Employee employee = employeeQualification.getEmployee();

        System.out.println("Nazwa uprawnienia: " + qualification.getQualificationName()
                            + " Dane posiadacza: " + employee.getEmployeeName() + " " + employee.getEmployeeLastName());

    }

}
