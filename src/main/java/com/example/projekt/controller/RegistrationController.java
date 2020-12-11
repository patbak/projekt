package com.example.projekt.controller;

import com.example.projekt.entity.UserDto;
import com.example.projekt.event.UserRegistrationEvent;
import com.example.projekt.model.User;
import com.example.projekt.repository.UserJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/uzytkownicy")
public class RegistrationController {
    @Autowired
    private UserJpaRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private ApplicationEventPublisher eventPublisher;


@PostMapping("/sign-up")
public void signUp(@Valid @RequestBody UserDto userDto){
 //System.out.println("Działa");
    User user = new User();
    user.setName(userDto.getFirstname());
    user.setLastName(userDto.getLastname());
    user.setEmail(userDto.getEmail());
    user.setLogin(userDto.getUsername());
    user.setPassword(encoder.encode(userDto.getPassword()));
    user.setPhoneNumber(userDto.getPhoneNumber());
    user.setSupervisor(userDto.isSupervisor());
    repository.saveAndFlush(user);

}





}
