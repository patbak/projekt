package com.example.projekt.validation;

import com.example.projekt.model.User;
import com.example.projekt.repository.AccountRepository;
import com.example.projekt.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    private UserJpaRepository repository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        if(email!=null&&repository.findByEmail(email) == null && accountRepository.findByEmail(email)==null){
            return true;
        }
        return false;
    }


}
