package com.example.projekt.entity;

import com.example.projekt.validation.PasswordConfirmed;
import com.example.projekt.validation.PasswordPolicy;

import javax.validation.constraints.NotEmpty;


public class PasswordDto {
    @NotEmpty
    private String token;
    @PasswordPolicy
    private String password;
    @NotEmpty(message="Please confirm your password")
    private String confirmPassword;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
