package com.example.projekt.validation;

import com.example.projekt.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {
    @Autowired
    private UserJpaRepository repository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if (username!=null && repository.findByLogin(username) == null){
            return true;
        }
      return false;
    }

}
