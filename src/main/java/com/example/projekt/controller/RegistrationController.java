package com.example.projekt.controller;

import com.example.projekt.entity.Account;
import com.example.projekt.entity.UserDto;
import com.example.projekt.event.UserRegistrationEvent;
import com.example.projekt.model.User;
import com.example.projekt.repository.AccountRepository;
import com.example.projekt.repository.UserJpaRepository;

import com.example.projekt.service.AccountService;
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
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private AccountService accountService;


@PostMapping("/sign-up")
public void signUp(@Valid @RequestBody UserDto userDto){
 //System.out.println("Działa");
/*    User user = new User();
    user.setName(userDto.getFirstname());
    user.setLastName(userDto.getLastname());
    user.setEmail(userDto.getEmail());
    user.setLogin(userDto.getUsername());
    user.setPassword(encoder.encode(userDto.getPassword()));
    user.setPhoneNumber(userDto.getPhoneNumber());
    user.setSupervisor(userDto.isSupervisor());*/
    Account account = new Account();

    account.setName(userDto.getFirstname());
    account.setLastName(userDto.getLastname());
    account.setEmail(userDto.getEmail());
    account.setLogin(userDto.getUsername());
    account.setPassword(encoder.encode(userDto.getPassword()));
    account.setPhoneNumber(userDto.getPhoneNumber());
    account.setSupervisor(userDto.isSupervisor());
    accountRepository.saveAndFlush(account);
    eventPublisher.publishEvent(new UserRegistrationEvent(account,"uzytkownicy"));

}







}
