package com.example.demo.redis;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@RedisHash
public class Role {
    @Id
    private String id;

    @Indexed
    private String name;
}
