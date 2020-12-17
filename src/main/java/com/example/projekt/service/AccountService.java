package com.example.projekt.service;

import com.example.projekt.entity.Account;
import com.example.projekt.model.User;

public interface AccountService {

    public Account create (Account account);

    void createVerificationToken(Account account, String token);

    void confirmAccount(String token);
}
