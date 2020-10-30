package com.example.projekt.model;


import com.example.projekt.repository.MaterialJpaRepository;
import com.example.projekt.repository.UsedMaterialJpaRepository;
import com.example.projekt.repository.UsedMaterialRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsedMaterialTest {

    @Autowired
    private UsedMaterialJpaRepository usedMaterialJpaRepository;

    @Autowired
    private UsedMaterialRepository usedMaterialRepository;


    @Test
    @Transactional
    public void testJpaFindByName()throws Exception{
       /* List<UsedMaterial> usedMaterials = usedMaterialJpaRepository.findAll();
        System.out.print(usedMaterials.get(0).getMaterial().getMaterialName()+" Ilośc: "
                +usedMaterials.get(0).getQuantity());*/
     /*
        UsedMaterial usedMaterial = usedMaterialRepository.find(1);
        System.out.print(usedMaterial.getMaterial().getMaterialName()+"Ilość"
                +usedMaterial.getQuantity());*/
        UsedMaterial usedMaterial = usedMaterialJpaRepository.getOne(1);
        System.out.print(usedMaterial.getMaterial().getMaterialName()+"Ilość"
                +usedMaterial.getQuantity());
        assertTrue(usedMaterial.getUsedMaterialId()==1);
    }

}
