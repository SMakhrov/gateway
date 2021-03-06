package ru.example.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.example.gateway.JwtTokenProvider;
import ru.example.gateway.dao.UserRepository;
import ru.example.gateway.model.Role;
import ru.example.gateway.model.User;

import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @Override
    public String login(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                password));
        User user = userRepository.findByName(username);
        //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
        //Since we are using custom token using JWT we should add ROLE_ prefix
        return jwtTokenProvider.createToken(username, user.getRoles().stream()
                .map(Role::getAuthority).collect(Collectors.toList()));
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()) );
        return userRepository.save(user);
    }

    @Override
    public Boolean isValidToken(String token) {
        return jwtTokenProvider.validateToken(token);
    }
}