package com.example.projekt.repository;

import com.example.projekt.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Repository
public class WorkRepository {

    @Autowired
    private WorkJpaRepository workJpaRepository;


    public Work create(Work work){
        return workJpaRepository.saveAndFlush(work);
    }

    public Work update(Work work){
        return workJpaRepository.saveAndFlush(work);
    }

    public void delete(int id){
        workJpaRepository.deleteById(id);
    }

    public Work find(int id){
       return workJpaRepository.getOne(id);
    }
}
