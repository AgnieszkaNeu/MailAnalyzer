package org.example;

import jakarta.mail.MessagingException;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws MessagingException {

        String mail = "my_mail@mail.com";
        String password = "password";

        EmailManager emailManager = new EmailManager(mail,password);
        ArrayList<Mail> mails = emailManager.getMails();
        ReportGenerator.generateXLSX("excel.xlsx");
        ReportGenerator.addDataToSheet("excel.xlsx", mails);

    }


}