package com.example.projekt.repository;

import com.example.projekt.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "maszyny", collectionResourceRel = "maszyny")
public interface MachineJpaRepository extends JpaRepository<Machine, Integer> {
}
