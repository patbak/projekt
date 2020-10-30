package com.example.projekt.repository;

import com.example.projekt.model.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QualificationRepository {

    @Autowired
    private QualificationJpaRepository qualificationJpaRepository;

    public Qualification create(Qualification qualification){
        return qualificationJpaRepository.saveAndFlush(qualification);
    }

    public Qualification update(Qualification qualification){
        return qualificationJpaRepository.saveAndFlush(qualification);
    }

    public void delete(int id){
        qualificationJpaRepository.deleteById(id);
    }

    public Qualification find(int id){
        return qualificationJpaRepository.getOne(id);
    }
}
