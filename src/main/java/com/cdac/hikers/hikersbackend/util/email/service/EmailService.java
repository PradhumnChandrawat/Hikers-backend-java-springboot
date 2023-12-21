package com.cdac.hikers.hikersbackend.util.email.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import com.cdac.hikers.hikersbackend.util.email.constants.EmailConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${email.username}")
    private String username;

    @Value("${email.password}")
    private String password;

    public String sendSimpleMail(String recipientName, String recipientEmail, String trip) {
        try {

            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "465");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.socketFactory.port", "465");
            prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            Authenticator authenticator = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            };

            Session session = Session.getInstance(prop, authenticator);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recipientEmail));
            message.setSubject(EmailConstants.EMAIL_SUBJECT);
            message.setText(String.format(EmailConstants.EMAIL_BODY, recipientName, trip));

            Transport.send(message);

            return "Mail Sent Successfully...";

        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while Sending Mail";
        }
    }

}
