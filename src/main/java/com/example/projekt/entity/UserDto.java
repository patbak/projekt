package com.example.projekt.entity;

import com.example.projekt.validation.PasswordConfirmed;
import com.example.projekt.validation.PasswordPolicy;
import com.example.projekt.validation.UniqueEmail;
import com.example.projekt.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@PasswordConfirmed
public class UserDto {

    @NotEmpty(message="Please enter your firstname")
    private String firstname;
    @NotEmpty(message="Please enter your lastname")
    private String lastname;
    @NotEmpty(message="Please enter an email")
    @Email(message="Email is not valid")
    @UniqueEmail
    private String email;
    @NotEmpty(message="Please enter a username")
    @UniqueUsername
    private String username;
    @NotEmpty(message="Please enter in a password")
    @PasswordPolicy
    private String password;
    @NotEmpty(message="Please confirm your password")
    private String confirmPassword;
    private String phoneNumber;
    private boolean isSupervisor;

    public UserDto(@NotEmpty(message = "Please enter your firstname") String firstname,
                   @NotEmpty(message = "Please enter your lastname") String lastname,
                   @NotEmpty(message = "Please enter an email") @Email(message = "Email is not valid") String email,
                   @NotEmpty(message = "Please enter a username") String username,
                   @NotEmpty(message = "Please enter in a password") String password,
                   @NotEmpty(message = "Please confirm your password") String confirmPassword,
                   @NotEmpty(message = "Please enter your phone number") String phoneNumber,
                   @NotEmpty(message = "Please enter is it supervisor") boolean isSupervisor) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phoneNumber = phoneNumber;
        this.isSupervisor = isSupervisor;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSupervisor() {
        return isSupervisor;
    }

    public void setSupervisor(boolean supervisor) {
        isSupervisor = supervisor;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
