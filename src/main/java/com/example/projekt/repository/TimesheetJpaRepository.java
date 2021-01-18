package com.example.projekt.repository;

import com.example.projekt.model.Employee;
import com.example.projekt.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
@RepositoryRestResource(path = "kartyPracy", collectionResourceRel = "kartyPracy")
public interface TimesheetJpaRepository extends JpaRepository<Timesheet, Integer> {

    List<Timesheet> findByReportDateAndEmployee_EmployeeId(Date date, int id);

    List<Timesheet> findAllByReportDateBetweenAndEmployee_EmployeeId(
            Date startOfMounth,
            Date endOfMounth,
            int id
            );

}
