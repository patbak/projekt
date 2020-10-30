package com.example.projekt.repository;


import com.example.projekt.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MaterialRepository {

    @Autowired
    private MaterialJpaRepository materialJpaRepository;

    public Material create(Material material){
        return materialJpaRepository.saveAndFlush(material);
    }

    public Material update(Material material){
        return materialJpaRepository.saveAndFlush(material);
    }

    public void delete(int id){
        materialJpaRepository.deleteById(id);
    }

    public Material find(int id){
         return materialJpaRepository.getOne(id);
    }




}
