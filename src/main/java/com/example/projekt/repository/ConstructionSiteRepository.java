package com.example.projekt.repository;

import com.example.projekt.model.ConstructionSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConstructionSiteRepository {
    @Autowired
    private ConstructionSiteJpaRepository constructionSiteJpaRepository;

    public ConstructionSite create(ConstructionSite constructionSite){
        return constructionSiteJpaRepository.saveAndFlush(constructionSite);
    }

    public ConstructionSite update(ConstructionSite constructionSite){
        return constructionSiteJpaRepository.saveAndFlush(constructionSite);
    }

    public void delete(int id){
        constructionSiteJpaRepository.deleteById(id);
    }

    public ConstructionSite find(int id){

        return constructionSiteJpaRepository.getOne(id);
    }
}
