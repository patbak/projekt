package com.example.projekt.repository;

import com.example.projekt.model.LabourStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LabourStandardRepository {

    @Autowired
    private LabourStandardJpaRepository labourStandardJpaRepository;

    public LabourStandard create(LabourStandard labourStandard){
        return labourStandardJpaRepository.saveAndFlush(labourStandard);
    }

    public LabourStandard update(LabourStandard labourStandard){
        return labourStandardJpaRepository.saveAndFlush(labourStandard);
    }

    public void delete(int id){
        labourStandardJpaRepository.deleteById(id);
    }

    public LabourStandard find(int id){
        return labourStandardJpaRepository.getOne(id);
    }

}
