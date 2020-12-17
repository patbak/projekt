package com.example.projekt.validation;

import com.example.projekt.entity.PasswordDto;
import com.example.projekt.entity.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConfirmedValidator implements ConstraintValidator<PasswordConfirmed, Object> {

    @Override
    public boolean isValid(Object user, ConstraintValidatorContext context) {
        String password = ((UserDto)user).getPassword();
        String confirmedPassword = ((UserDto)user).getConfirmPassword();
        return password.equals(confirmedPassword);
    }



}
