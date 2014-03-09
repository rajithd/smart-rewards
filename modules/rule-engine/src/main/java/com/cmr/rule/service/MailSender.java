package com.cmr.rule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author rajith
 */
@Service
public class MailSender {

    @Autowired
    private JavaMailSender mail;
    @Value("${email.recipient}")
    private String recipient;
    @Value("${email.username}")
    private String from;

    public void send(String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(body);
        mail.send(message);
    }

}
