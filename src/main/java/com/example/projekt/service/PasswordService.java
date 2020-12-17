package com.example.projekt.service;

import com.example.projekt.entity.PasswordDto;
import com.example.projekt.model.ResetToken;
import com.example.projekt.model.User;

public interface PasswordService {
    void createResetToken(User user);

   ResetToken confirmResetToken(String token);

    void sendResetMail(String token, User user);

    void update(ResetToken resetToken, PasswordDto passwordDto);

    User checkEmail(String email);

}
