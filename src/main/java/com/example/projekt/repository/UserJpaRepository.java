package com.example.projekt.repository;

import com.example.projekt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<User,Integer> {
    List<User> findByNameContains(String name);
}
