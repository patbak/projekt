package com.example.projekt.repository;

import com.example.projekt.model.WorkDone;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkDoneRepository {

    @Autowired
    private WorkDoneJpaRepository workDoneJpaRepository;

    public WorkDone create(WorkDone workDone){
        return workDoneJpaRepository.saveAndFlush(workDone);
    }

    public WorkDone update(WorkDone workDone){
        return workDoneJpaRepository.saveAndFlush(workDone);
    }

    public void delete(int id){
        workDoneJpaRepository.deleteById(id);
    }

    public WorkDone find(int id){
        return workDoneJpaRepository.getOne(id);
    }

}
