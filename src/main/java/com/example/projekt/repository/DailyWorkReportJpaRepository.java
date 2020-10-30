package com.example.projekt.repository;

import com.example.projekt.model.DailyWorkReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyWorkReportJpaRepository  extends JpaRepository<DailyWorkReport, Integer>
{
}
