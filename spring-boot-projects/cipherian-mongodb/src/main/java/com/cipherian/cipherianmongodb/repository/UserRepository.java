package com.cipherian.cipherianmongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cipherian.cipherianmongodb.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    boolean existsByUsername(@Param("username") String username);

    Optional<User> findByUsername(@Param("username") String username);

    Optional<User> findByEmail(@Param("email") String email);
}
