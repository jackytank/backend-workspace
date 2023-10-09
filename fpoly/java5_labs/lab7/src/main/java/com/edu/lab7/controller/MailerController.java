package com.edu.lab7.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.edu.lab7.domain.MailModel;
import com.edu.lab7.helper.MailHelper;
import com.edu.lab7.service.MailService;

@Controller
@RequestMapping("mailer")
public class MailerController {
    @Autowired
    MailService mailer;

    @GetMapping("/index")
    public String index() {
        return "email";
    }

    @PostMapping("/send")
    public String send(Model model,
            @RequestParam String txtTo,
            @RequestParam String txtCC,
            @RequestParam String txtBCC,
            @RequestParam String txtSubject,
            @RequestParam String txtContent,
            @RequestParam("file") MultipartFile multipartFile,
            @RequestParam("file1") MultipartFile multipartFile1) {

        MailHelper helper = new MailHelper();
        List<File> files = new ArrayList<>();
        String[] emailCC = helper.parseStringEmailToArray(txtCC);
        String[] emailBCC = helper.parseStringEmailToArray(txtBCC);
        MailModel mail = new MailModel();
        mail.setTo(txtTo);
        mail.setCc(emailCC);
        mail.setBcc(emailBCC);
        mail.setSubject(txtSubject);
        mail.setBody(txtContent);
        if (multipartFile != null) {
            File file = null;
            try {
                file = helper.convertMultiPartFileToFile(multipartFile);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            files.add(file);
            mail.setFiles(files);
        }
        if (multipartFile1 != null) {
            File file = null;
            try {
                file = helper.convertMultiPartFileToFile(multipartFile1);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            files.add(file);
            mail.setFiles(files);
        }
        System.out.println(mail.toString());
        mailer.push(mail);
        if (MailHelper.error.equals("")) {
            model.addAttribute("message", "Send success!");
        } else {
            model.addAttribute("message", "Send fail! Error: " + MailHelper.error);
        }

        return "email";
        // return String.format("<h1>Mail của bạn chua dc gui di</h1>"
        // + "<h1>Error message: %s</h1>", error);
    }
}
