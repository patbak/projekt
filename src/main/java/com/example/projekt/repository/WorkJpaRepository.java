package com.example.projekt.repository;

import com.example.projekt.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RepositoryRestResource(path = "roboty", collectionResourceRel = "roboty")
public interface WorkJpaRepository extends JpaRepository<Work, Integer> {

}
