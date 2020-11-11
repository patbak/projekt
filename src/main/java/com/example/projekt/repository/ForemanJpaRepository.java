package com.example.projekt.repository;

import com.example.projekt.model.Foreman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
@RepositoryRestResource(path = "brygadzisci", collectionResourceRel = "brygadzisci")
public interface ForemanJpaRepository extends JpaRepository<Foreman,Integer> {
}
