package com.example.projekt.repository;

import com.example.projekt.model.Foreman;
import org.springframework.beans.factory.annotation.Autowired;

public class ForemanRepository {

    @Autowired
    private ForemanJpaRepository foremanJpaRepository;

    public Foreman create(Foreman foreman){
        return foremanJpaRepository.saveAndFlush(foreman);
    }

    public  Foreman update(Foreman foreman){
        return foremanJpaRepository.saveAndFlush(foreman);
    }

    public void delete(int id){
        foremanJpaRepository.deleteById(id);
    }

    public Foreman find(int id){
        return foremanJpaRepository.getOne(id);
    }


}
