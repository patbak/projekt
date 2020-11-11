package com.example.projekt.repository;

import com.example.projekt.model.DailyMachineWorkReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "raportMaszyn", collectionResourceRel = "raportMaszyn")
public interface DailyMachineWorkReportJpaRepository  extends JpaRepository<DailyMachineWorkReport,Integer> {
}
