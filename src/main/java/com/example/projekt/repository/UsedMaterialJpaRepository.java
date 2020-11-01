package com.example.projekt.repository;

import com.example.projekt.model.UsedMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedMaterialJpaRepository extends JpaRepository<UsedMaterial,Integer> {
}
