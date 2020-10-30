package com.example.projekt.model;

import com.example.projekt.repository.UserJpaRepository;
import com.example.projekt.repository.WorkJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class WorkTest {
    @Autowired
    private WorkJpaRepository workJpaRepository;

    @Test
    public void testJpa()throws Exception{
    List<Work> works = workJpaRepository.findAll();
    assertTrue(works.size()>0);
    System.out.println("Roboty: "+works.get(0).getWorkName()
            +", "+works.get(1).getWorkName());

    }


}