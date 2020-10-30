package com.example.projekt.repository;

import com.example.projekt.model.UsedMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsedMaterialRepository {

    @Autowired
    private UsedMaterialJpaRepository usedMaterialJpaRepository;

    public UsedMaterial create(UsedMaterial usedMaterial){
        return usedMaterialJpaRepository.saveAndFlush(usedMaterial);
    }

    public UsedMaterial update(UsedMaterial usedMaterial){
        return usedMaterialJpaRepository.saveAndFlush(usedMaterial);
    }

    public void delete(int id){
        usedMaterialJpaRepository.deleteById(id);
    }

    public UsedMaterial find(int id){

        return usedMaterialJpaRepository.getOne(id);
    }

}
