package ru.example.gateway.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodeUtil {
    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public static void main(String[] args) {
        String password = "password";
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword);
    }
}
