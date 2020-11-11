package com.example.projekt.repository;

import com.example.projekt.model.ConstructionSite;
import com.example.projekt.model.Material;
import com.example.projekt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "materialy", collectionResourceRel = "materialy")
public interface MaterialJpaRepository extends JpaRepository<Material,Integer> {

    List<Material> findByMaterialNameContains(String materialName);
    Material findByMaterialId(int id);


}
