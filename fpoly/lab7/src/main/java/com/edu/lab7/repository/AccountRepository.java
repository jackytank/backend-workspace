package com.edu.lab7.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.edu.lab7.entity.Account;
import com.edu.lab7.model.Provider;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Query("SELECT u FROM Account u WHERE u.user_name = ?1")
    public Optional<Account> findByUser_name(String user_name);

    @Query("SELECT u FROM Account u WHERE u.email = ?1")
    public Account findByEmail(String email);

    @Modifying
    @Query("UPDATE Account u SET u.provider = ?2 WHERE u.email = ?1")
    public void updateAuthenticationTypeOAuth(String email, Provider provider);

    @Modifying
    @Query("UPDATE Account u SET u.provider = ?2 WHERE u.user_name = ?1")
    public void updateAuthenticationTypeDB(String user_name, Provider provider);

}
