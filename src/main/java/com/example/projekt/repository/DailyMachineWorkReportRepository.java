package com.example.projekt.repository;

import com.example.projekt.model.DailyMachineWorkReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DailyMachineWorkReportRepository {

    @Autowired
    private DailyMachineWorkReportJpaRepository dailyMachineWorkReportJpaRepository;

    public DailyMachineWorkReport create(DailyMachineWorkReport dailyMachineWorkReport){
        return dailyMachineWorkReportJpaRepository.saveAndFlush(dailyMachineWorkReport);
    }

    public DailyMachineWorkReport update(DailyMachineWorkReport dailyMachineWorkReport){
        return dailyMachineWorkReportJpaRepository.saveAndFlush(dailyMachineWorkReport);
    }

    public void delete(int id){
        dailyMachineWorkReportJpaRepository.deleteById(id);
    }

    public DailyMachineWorkReport find(int id){
        return dailyMachineWorkReportJpaRepository.getOne(id);
    }


}
