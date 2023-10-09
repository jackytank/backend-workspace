package com.edu.lab7.helper;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class MailHelper {
    public static String error = "";

    public String[] parseStringEmailToArray(String emailString) {
        String[] arrMail = null;
        if (emailString.length() > 0) {
            emailString = removeSpace(emailString);
            arrMail = emailString.split(",");
        }
        return arrMail;
    }

    public String removeSpace(String string) {
        return string.replaceAll(" ", "");
    }

    public File convertMultiPartFileToFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + multipartFile.getOriginalFilename());
        multipartFile.transferTo(convFile);
        return convFile;
    }
}
