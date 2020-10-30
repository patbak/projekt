package com.example.projekt.repository;

import com.example.projekt.model.DailyMachineWorkReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyMachineWorkReportJpaRepository  extends JpaRepository<DailyMachineWorkReport,Integer> {
}
