package com.example.projekt.model;


import com.example.projekt.repository.MaterialJpaRepository;
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
public class MaterialTest {

    @Autowired
    private MaterialJpaRepository materialJpaRepository;


    @Test
    @Transactional
    public void testJpaFindByName()throws Exception{

   // List<Material> materials = materialJpaRepository.findByMaterialNameContains("cement");
    Material material = materialJpaRepository.getOne(1);
    System.out.print("Nazwa: " + material.getMaterialName()
            + " " + material.getMaterialUnit());
    assertTrue(material.getMaterialId()==1);

    }

}
