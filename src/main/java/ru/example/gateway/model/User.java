package ru.example.gateway.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Document
@Data
public class User {
    @Id
    private String id;
    @Email(message = "*Please provide a valid email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    @NotEmpty(message = "*Please provide your name")
    private String password;
    @NotEmpty(message = "*Please provide your name")
    private String name;
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;
    private boolean isAccountNonExpired;
    private boolean isAccountLocked=false;
    private boolean isCredentialsExpired=false;
    private boolean isEnabled=true;
    private Set<Role> role;
}
