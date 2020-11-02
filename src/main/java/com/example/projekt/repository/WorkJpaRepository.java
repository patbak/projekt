package com.example.projekt.repository;

import com.example.projekt.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WorkJpaRepository extends JpaRepository<Work, Integer> {

}
