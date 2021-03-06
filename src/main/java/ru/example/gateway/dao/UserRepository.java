package ru.example.gateway.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.gateway.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
