package com.example.projekt.controller;

import com.example.projekt.entity.PasswordDto;
import com.example.projekt.model.ResetToken;
import com.example.projekt.model.User;
import com.example.projekt.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PasswordController {

    @Autowired
    private PasswordService  passwordService;

    @PostMapping("/resetPassword")
    public ResponseEntity<String> sendEmailToReset(@RequestParam String email){

        User user = passwordService.checkEmail(email);
        if(user==null){
            return new ResponseEntity<>(
                    "Uźytkownik o podanym email nie istnieje",  HttpStatus.BAD_REQUEST
            );
        }else {
            passwordService.createResetToken(user);
            return new ResponseEntity<>("Wysłano email z prośbą o zmianę hasła", HttpStatus.OK);
        }
    }

    @PostMapping("/confirmResetToken")
    public ResponseEntity<String> getNewPassword(@Valid @RequestBody PasswordDto passwordDto){
        ResetToken resetToken = passwordService.confirmResetToken(passwordDto.getToken());

        if(resetToken==null){
            return new ResponseEntity<>("Błędny token", HttpStatus.BAD_REQUEST);
        }else{
            passwordService.update(resetToken,passwordDto);
            return new ResponseEntity<>("Hasło zmienione", HttpStatus.OK);
        }

    }

}
