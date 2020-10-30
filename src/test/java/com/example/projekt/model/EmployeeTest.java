package com.example.projekt.model;


import com.example.projekt.repository.EmployeeJpaRepository;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Test
    @Transactional
    public void testJpaGetEmployee(){
        Employee employee  = employeeJpaRepository.getOne(2);
        assertTrue(employee.getEmployeeName().equals("Patryk"));

        System.out.print("Imie: " + employee.getEmployeeName()+
                        " Nazwisko: " + employee.getEmployeeLastName()+
                        " Stawka godzinowa: " + employee.getHourlyRate());

    }

}
