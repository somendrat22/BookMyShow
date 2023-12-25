package com.bookmyshow.Book.My.Show.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {


    @Autowired
    JavaMailSender javaMailSender;

    public void generateMail(String to, String sub, String body){
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try{
            helper.setTo(to);
            helper.setSubject(sub);
            helper.setText(body);
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
