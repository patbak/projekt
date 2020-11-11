package com.example.projekt.repository;

import com.example.projekt.model.LabourStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "normyPracy", collectionResourceRel = "normyPracy")
public interface LabourStandardJpaRepository extends JpaRepository<LabourStandard,Integer> {
}
