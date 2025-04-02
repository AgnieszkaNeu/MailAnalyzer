package org.example;

import java.util.Properties;

public class SessionProperties {

    private static final String IMAPhost = "imap.gmail.com";
    private static final String SMTPhost = "smtp.gmail.com";

    public static Properties receiveProperties(){
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imaps.host", IMAPhost);
        properties.put("mail.imaps.port", "993");
        properties.put("mail.imaps.ssl.enable", "true");
        return properties;
    }

    public static Properties sendProperties(){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTPhost);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        return properties;
    }
}
