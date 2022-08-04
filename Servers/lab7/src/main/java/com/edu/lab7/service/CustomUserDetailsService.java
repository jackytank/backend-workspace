package com.edu.lab7.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.lab7.auth.MyUserDetails;
import com.edu.lab7.entity.Account;
import com.edu.lab7.repository.AccountRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepo.findByUser_name(username);
        account.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return account.map(MyUserDetails::new).get();
    }

    // public void loginFromOAuth2(OAuth2AuthenticationToken oToken){
    //     String email = oToken.getPrincipal().getAttribute("email");
    //     String password = Long.toHexString(System.currentTimeMillis());

    //     UserDetails user = User.withUsername(email).password(password).au
    // }
}
