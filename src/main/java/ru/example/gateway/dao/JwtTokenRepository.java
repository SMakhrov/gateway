package ru.example.gateway.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.gateway.model.Token;

@Repository
public interface JwtTokenRepository extends JpaRepository<Token, String> {
}