package com.example.demo.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findFirstByEmail(@Param("email") String cc);
}
