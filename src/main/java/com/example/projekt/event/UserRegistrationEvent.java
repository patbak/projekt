package com.example.projekt.event;

import com.example.projekt.model.User;
import org.springframework.context.ApplicationEvent;

public class UserRegistrationEvent extends ApplicationEvent {
    private static final long serialVersionUID = -4113549487933175429L;
    private final User user;

    public UserRegistrationEvent(User user) {
        super(user);
        this.user=user;
    }
}
