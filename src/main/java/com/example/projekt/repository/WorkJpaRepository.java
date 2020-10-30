package com.example.projekt.repository;

import com.example.projekt.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkJpaRepository extends JpaRepository<Work, Integer> {

}
