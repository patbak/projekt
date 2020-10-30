package com.example.projekt.repository;

import com.example.projekt.model.ConstructionSite;
import com.example.projekt.model.Material;
import com.example.projekt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialJpaRepository extends JpaRepository<Material,Integer> {

    List<Material> findByMaterialNameContains(String materialName);
    Material findByMaterialId(int id);


}
