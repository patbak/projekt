package com.example.projekt.repository;

import com.example.projekt.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "kartyPracy", collectionResourceRel = "kartyPracy")
public interface TimesheetJpaRepository extends JpaRepository<Timesheet, Integer> {
}
