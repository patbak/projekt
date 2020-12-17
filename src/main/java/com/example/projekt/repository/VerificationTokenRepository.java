package com.example.projekt.repository;

import com.example.projekt.model.User;
import com.example.projekt.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,String> {
    VerificationToken findByToken(String token);
}
