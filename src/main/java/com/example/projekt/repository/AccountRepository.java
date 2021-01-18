
package com.example.projekt.repository;

import com.example.projekt.entity.Account;
import com.example.projekt.model.User;
import com.example.projekt.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "konto", collectionResourceRel = "konto")
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByLogin(String login);
    Account findByEmail(String email);
}

