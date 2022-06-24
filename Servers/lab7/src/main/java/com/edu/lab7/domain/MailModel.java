package com.edu.lab7.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MailModel {
    String from = "jackytbackup01";
    String to;
    String subject;
    String body;
    String[] cc;
    String[] bcc;
    List<File> files = new ArrayList<>();

    public MailModel() {
    }

    public MailModel(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String[] getCc() {
        return this.cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String[] getBcc() {
        return this.bcc;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    public List<File> getFiles() {
        return this.files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public MailModel from(String from) {
        setFrom(from);
        return this;
    }

    public MailModel to(String to) {
        setTo(to);
        return this;
    }

    public MailModel subject(String subject) {
        setSubject(subject);
        return this;
    }

    public MailModel body(String body) {
        setBody(body);
        return this;
    }

    public MailModel cc(String[] cc) {
        setCc(cc);
        return this;
    }

    public MailModel bcc(String[] bcc) {
        setBcc(bcc);
        return this;
    }

    public MailModel files(List<File> files) {
        setFiles(files);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MailModel)) {
            return false;
        }
        MailModel mailModel = (MailModel) o;
        return Objects.equals(from, mailModel.from) && Objects.equals(to, mailModel.to)
                && Objects.equals(subject, mailModel.subject) && Objects.equals(body, mailModel.body)
                && Objects.equals(cc, mailModel.cc) && Objects.equals(bcc, mailModel.bcc)
                && Objects.equals(files, mailModel.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, subject, body, cc, bcc, files);
    }

    @Override
    public String toString() {
        return "{" +
                " from='" + getFrom() + "'" +
                ", to='" + getTo() + "'" +
                ", subject='" + getSubject() + "'" +
                ", body='" + getBody() + "'" +
                ", cc='" + getCc() + "'" +
                ", bcc='" + getBcc() + "'" +
                ", files='" + getFiles() + "'" +
                "}";
    }

}
