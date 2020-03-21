package ru.example.gateway.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.example.gateway.model.JwtToken;

@Repository
public interface JwtTokenRepository extends MongoRepository<JwtToken, String> {
}