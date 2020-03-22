package ru.example.gateway.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.example.gateway.service.LoginService;
import ru.example.gateway.to.AuthResponse;
import ru.example.gateway.to.LoginRequest;

@Controller
@RequestMapping("/api")
public class LoginRestController {

    @Autowired
    private LoginService loginService;

    @CrossOrigin("*")
    @PostMapping("/signin")
    @ResponseBody
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = loginService.login(loginRequest.getUsername(),loginRequest.getPassword());
        return new ResponseEntity<>(new AuthResponse(token), HttpStatus.CREATED);
    }

    @PostMapping("/valid/token")
    @ResponseBody
    public Boolean isValidToken (@RequestHeader(value="Authorization") String token) {
        return loginService.isValidToken(token);
    }
}