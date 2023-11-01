package com.cipherian.cipherianmongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;
import lombok.Data;

@Document(collection = "users")
@Data
@Builder
public class User {
    @Id
    private Integer id;
    private String username;
    private String email;
    private String password;
}
