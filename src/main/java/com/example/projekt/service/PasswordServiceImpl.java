package com.example.projekt.service;

import com.example.projekt.entity.PasswordDto;
import com.example.projekt.model.ResetToken;
import com.example.projekt.model.User;
import com.example.projekt.repository.ResetTokenRepository;
import com.example.projekt.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private ResetTokenRepository resetTokenRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private PasswordEncoder encoder;

    private String serverUrl = "http://localhost:8080/";

    @Override
    public void createResetToken(User user) {
        String token = UUID.randomUUID().toString();
        ResetToken resetToken = new ResetToken();
        resetToken.setToken(token);
        resetToken.setEmail(user.getEmail());
        resetToken.setUsername(user.getLogin());
        resetToken.setExpiryDate(resetToken.calculateExpiryDate(resetToken.EXPIRATION));
        resetTokenRepository.saveAndFlush(resetToken);
        sendResetMail(token,user);
    }

    @Override
    public void sendResetMail(String token, User user) {
        String recipientAddress = user.getEmail();
        String subject = "Reset Password";
        String confirmationUrl = "/passwordReset?token=" + token;
        String message = "Reset password:";
        //send email
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + "\r\n" + serverUrl + confirmationUrl);

        mailSender.send(email);
        System.out.println("Wysyłanie maila");
    }

   @Override
    public ResetToken confirmResetToken(String token) {
        ResetToken resetToken = resetTokenRepository.findByToken(token);
        if(resetToken==null)
        return null;
        return resetToken;
    }

    @Override
    public void update(ResetToken resetToken, PasswordDto passwordDto) {
        User user = userJpaRepository.findByEmail(resetToken.getEmail());
        user.setPassword(encoder.encode(passwordDto.getPassword()));
        userJpaRepository.saveAndFlush(user);
    }

    @Override
    public User checkEmail(String email) {
        User user = userJpaRepository.findByEmail(email);
       if(user==null){
           return null;
       }else{
           return user;
       }


    }
}
