package com.edu.lab7.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletRequest;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;

import com.edu.lab7.domain.MailModel;
import com.edu.lab7.helper.MailHelper;
import com.edu.lab7.service.MailService;

@Service
public class MailServiceImpl implements MailService {

    List<MailModel> list = new ArrayList<>();

    @Autowired
    JavaMailSender sender;

    @Override
    public void send(MailModel mail) {
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), true);
            helper.setReplyTo(mail.getFrom());

            String[] listCc = mail.getCc();
            if (listCc != null && listCc.length > 0) {
                helper.setCc(listCc);
            }

            String[] ListBcc = mail.getBcc();
            if (ListBcc != null && ListBcc.length > 0) {
                helper.setBcc(ListBcc);
            }

            List<File> listFile = mail.getFiles();
            if (listFile.size() > 0) {
                for (File file : listFile) {
                    helper.addAttachment(file.getName(), file);
                }
            }
            sender.send(message);

        } catch (Exception e) {
            MailHelper.error = e.getMessage();
        }
    }

    @Override
    public void send(String to, String subject, String body) {
        this.send(new MailModel(to, subject, body));

    }

    @Override
    public void push(MailModel mail) {
        list.add(mail);
    }

    @Override
    public void push(String to, String subject, String body) {
        this.push(new MailModel(to, subject, body));

    }

    @Scheduled(fixedDelay = 1000)
    public void run() {
        int success = 0, error = 0;
        while (!list.isEmpty()) {
            MailModel mail = list.remove(0);
       
                this.send(mail);
                success++;

        }
        System.out.printf(">> Sent: %d, Error %d\r\n", success, error);
    }

}
