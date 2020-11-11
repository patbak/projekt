package com.example.projekt.repository;

import com.example.projekt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "pracownicy", collectionResourceRel = "pracownicy")
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
}
