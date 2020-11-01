package com.example.projekt.repository;

import com.example.projekt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User,Integer> {
    List<User> findByNameContains(String name);
}
