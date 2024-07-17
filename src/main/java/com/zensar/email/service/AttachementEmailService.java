package com.zensar.email.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class AttachementEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendAttachmentEmail(String toEmail, String subject, String body) throws MessagingException {
        System.out.println("sending attachment Email...");
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body);
        helper.setFrom(fromEmail);

        FileSystemResource file = new FileSystemResource(new File("D:\\COMPANY\\Documents\\PANCARD.pdf"));
        helper.addAttachment(file.getFilename(), file);

        javaMailSender.send(message);
        System.out.println("Attachment Email sent successfully");
    }
}
