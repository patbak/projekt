package com.example.projekt.repository;

import com.example.projekt.model.WorkDone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "wykonaneRoboty", collectionResourceRel = "wykonaneRoboty")
public interface WorkDoneJpaRepository extends JpaRepository<WorkDone, Integer> {

}
