package com.example.projekt.repository;


import com.example.projekt.model.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface ResetTokenRepository extends JpaRepository<ResetToken, String> {
    ResetToken findByToken(String token);
}
