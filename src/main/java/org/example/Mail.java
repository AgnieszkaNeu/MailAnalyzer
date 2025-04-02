package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Mail {

    String senderMail;
    String subject;
    Date date;
    String category = "";

    public Mail(String mail, String subject, Date date) {
        this.senderMail = mail;
        this.subject = subject;
        this.date = date;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
