package com.example.projekt.model;

import com.example.projekt.repository.MachineJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MachineTest {

    @Autowired
    private MachineJpaRepository machineJpaRepository;

    @Test
    @Transactional
    public void testMachineGetOne(){
        Machine machine = machineJpaRepository.getOne(1);

        DailyMachineWorkReport dailyMachineWorkReport = machine.getDailyMachineWorkReports().get(0);

        assertTrue(machine.getMachineName().equals("JCB"));

        System.out.print("Nazwa maszyny: " + machine.getMachineName()
                        +" Numer inwentarzowy: " + machine.getInventoryNumber()
                        +" Numer raportu:  " + dailyMachineWorkReport.getReportNumber()
                        +" Zadanie: " + dailyMachineWorkReport.getTask());

    }
}
