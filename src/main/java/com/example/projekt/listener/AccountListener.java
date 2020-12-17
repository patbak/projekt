package com.example.projekt.listener;

import com.example.projekt.entity.Account;
import com.example.projekt.event.UserRegistrationEvent;
import com.example.projekt.model.User;
import com.example.projekt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountListener implements ApplicationListener<UserRegistrationEvent> {

    private String serverUrl = "https://localhost:443/";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AccountService accountService;

    @Override
    public void onApplicationEvent(UserRegistrationEvent event) {
        this.confirmCreateAccount(event);
    }

    private void confirmCreateAccount(UserRegistrationEvent event) {
        System.out.println("Wysyłąnie maila");
        //get the account
        //create verification token
        Account account = event.getAccount();
        System.out.println(account.getLogin());
        String token = UUID.randomUUID().toString();
        accountService.createVerificationToken(account, token);
        //get email properties
        String recipientAddress = account.getEmail();
        String subject = "Account Confirmation";
        String confirmationUrl = "accountConfirm?token=" + token;
        String message = "Please confirm:";
        //send email
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + "\r\n" + serverUrl + confirmationUrl);
        mailSender.send(email);

    }
}
