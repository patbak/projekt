package com.example.projekt.repository;

import com.example.projekt.model.DailyWorkReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyWorkReportJpaRepository  extends JpaRepository<DailyWorkReport, Integer>
{
}
