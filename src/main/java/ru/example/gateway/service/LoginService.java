package ru.example.gateway.service;

import ru.example.gateway.model.User;

public interface LoginService {
    String login(String username, String password);

    User saveUser(User user);

    boolean logout(String token);

    Boolean isValidToken(String token);
}