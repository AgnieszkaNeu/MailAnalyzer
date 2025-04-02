package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.MimeMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class EmailManager {

    private final String mail;
    private final String password;

    public EmailManager(String mail, String password){
        this.password = password;
        this.mail = mail;
    }

    public ArrayList<Mail> getMails() throws MessagingException {

        Properties properties = SessionProperties.receiveProperties();
        Session session = Session.getInstance(properties, null);

        Store store = session.getStore("imaps");
        store.connect(mail, password);
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        Message [] messages = inbox.getMessages();

        ArrayList<Mail> mails = new ArrayList<>();

        for(Message message : messages){
            String senderMail = StringProcessor.extractEmail(String.valueOf(message.getFrom()[0]));
            Mail mail1 = new Mail(senderMail, message.getSubject(), message.getSentDate());
            mails.add(mail1);
        }
        inbox.close();
        store.close();

        return mails;
    }

    public void sendMail(String sentTo, String content){

        Properties properties = SessionProperties.sendProperties();
        Session session = Session.getInstance(properties, null);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(mail);
            msg.setRecipients(Message.RecipientType.TO, sentTo);
            msg.setSubject("Subject");
            msg.setSentDate(new Date());
            msg.setText(content);
            Transport.send(msg, mail, password);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
