package com.example.projekt.model;

import com.example.projekt.repository.ConstructionSiteJpaRepository;
import com.example.projekt.repository.UserJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ConstructionSiteTest {

    @Autowired
    private ConstructionSiteJpaRepository constructionSiteJpaRepository;


    @Test
    public void testJpaFindByName()throws Exception{
    List<ConstructionSite> constructionSites = constructionSiteJpaRepository.findByNameContains("Kurów");
        User user = constructionSites.get(0).getUser();
        System.out.println("Nazwa: "+constructionSites.get(0).getName()+"Imie kerownika: "+user.getName());
        assertTrue(constructionSites.size()>0);
    }







}
