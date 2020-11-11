package com.example.projekt.repository;

import com.example.projekt.model.EmployeeQualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "uprawnieniaPracownikow", collectionResourceRel = "uprawnieniaPracownikow")
public interface EmployeeQualificationJpaRepository extends JpaRepository<EmployeeQualification, Integer> {
}
