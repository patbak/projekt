package com.example.projekt.repository;


import com.example.projekt.model.DailyWorkReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DailyWorkReportRepository {

    @Autowired
    private DailyWorkReportJpaRepository dailyWorkReportJpaRepository;

    public DailyWorkReport create(DailyWorkReport dailyWorkReport){
    return dailyWorkReportJpaRepository.saveAndFlush(dailyWorkReport);
    }

    public DailyWorkReport update(DailyWorkReport dailyWorkReport){
        return dailyWorkReportJpaRepository.saveAndFlush(dailyWorkReport);
    }

    public void delete(int id){
        dailyWorkReportJpaRepository.deleteById(id);
    }

    public DailyWorkReport find(int id){
        return dailyWorkReportJpaRepository.getOne(id);
    }
}
