package com.edu.lab7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.lab7.entity.Account;
import com.edu.lab7.model.Provider;
import com.edu.lab7.repository.AccountRepository;

@Service
@Transactional
public class UserService {
    @Autowired
    private AccountRepository repo;

    public void processOAuthPostLogin(String username, String email, String image, String oauth2ClientName) {
        Account existAcc = repo.findByEmail(email);
        if (existAcc == null) {
            Account newAcc = new Account();
            Provider provider = Provider.valueOf(oauth2ClientName.toUpperCase());
            newAcc.setUser_name(username);
            newAcc.setEmail(email);
            newAcc.setProvider(provider);
            newAcc.setPhoto(image);
            repo.save(newAcc);
        }
    }

    public void updateAuthenticationTypeOAuth(String username, String oauth2ClientName) {
        Provider provider = Provider.valueOf(oauth2ClientName.toUpperCase());
        repo.updateAuthenticationTypeOAuth(username, provider);
    }

    public void updateAuthenticationTypeDB(String username, String oauth2ClientName) {
        Provider provider = Provider.valueOf(oauth2ClientName.toUpperCase());
        repo.updateAuthenticationTypeDB(username, provider);
    }
}
