package com.example.projekt.repository;

import com.example.projekt.model.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MachineRepository {

    @Autowired
    private MachineJpaRepository machineJpaRepository;

    public Machine create(Machine machine){
        return machineJpaRepository.saveAndFlush(machine);
    }

    public Machine update(Machine machine){
        return machineJpaRepository.saveAndFlush(machine);
    }

    public void delete(int id){
        machineJpaRepository.deleteById(id);
    }

    public Machine find(int id){
        return machineJpaRepository.getOne(id);
    }

}
