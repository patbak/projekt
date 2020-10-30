package com.example.projekt.model;

import com.example.projekt.repository.LabourStandardJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class LabourStandardTest {

    @Autowired
    private LabourStandardJpaRepository labourStandardJpaRepository;

    @Test
    @Transactional
     public void testGetOne() throws Exception {
        LabourStandard labourStandard = labourStandardJpaRepository.getOne(1);

        assertTrue(labourStandard.getWorkName().equals("Ułożenie kostki"));

        WorkDone workDone = labourStandard.getWorkDoneList().get(0);

        System.out.print("Nazwa roboty: " + labourStandard.getWorkName()
                        +" ilość: " + workDone.getQuantity());

    }
}
