package com.java.jungle.component;

import com.java.jungle.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import sun.java2d.pipe.SpanShapeRenderer;

@Component
public class EmailComponent implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMessage(String to) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("JungleNoReply@Corp.com");
        message.setTo(to);
        message.setSubject("Message From Jungle!");
        message.setText("your order has been confirmed");


        mailSender.send(message);

    }
}
