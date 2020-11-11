package com.example.projekt.repository;

import com.example.projekt.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "uprawnienia", collectionResourceRel = "uprawnienia")
public interface QualificationJpaRepository extends JpaRepository<Qualification, Integer> {
}
