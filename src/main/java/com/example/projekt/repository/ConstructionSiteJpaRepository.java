package com.example.projekt.repository;
import com.example.projekt.model.ConstructionSite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path = "budowa", collectionResourceRel = "budowa")

public interface ConstructionSiteJpaRepository extends JpaRepository<ConstructionSite,Integer> {

     List<ConstructionSite> findByNameContains(String name);

     @Override
     @PreAuthorize("hasAuthority('ENGIENEER')")
     Page<ConstructionSite> findAll(Pageable pageable);

}
