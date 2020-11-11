package com.example.projekt.repository;

import com.example.projekt.model.DailyWorkReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "raportBrygady", collectionResourceRel = "raportBrygady")
public interface DailyWorkReportJpaRepository  extends JpaRepository<DailyWorkReport, Integer>
{
}
