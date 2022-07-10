package com.edu.lab7.service;

import javax.mail.MessagingException;

import com.edu.lab7.domain.MailModel;

public interface MailService {
    void send(MailModel mail) throws MessagingException;

    void send(String to, String subject, String body) throws MessagingException;

    void push(MailModel mail);

    void push(String to, String subject, String body);

}
