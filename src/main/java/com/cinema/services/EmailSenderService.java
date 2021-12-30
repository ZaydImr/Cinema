package com.cinema.services;

import com.cinema.models.Subscription;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    @Autowired
    private final JavaMailSender mailSender;
    private final SubscriptionService subscriptionService;

    public void sendSimpleEmail(String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setText(body);
        message.setSubject(subject);
        List<Subscription> subscriptions = subscriptionService.getAll();
        for (Subscription s : subscriptions) {
            message.setTo(s.getEmailSubscriber());
            mailSender.send(message);
        }
        System.out.println("Mail Send...");
    }

    public void sendEmailByUser(String recipientEmail,String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println("Mail entered...");

        message.setText(body);
        message.setSubject(subject);
        message.setTo(recipientEmail);
        mailSender.send(message);
        System.out.println("Mail Send...");
    }

    public void sendEmailWithAttachment(String body, String subject, String attachment) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("cinemaemailsender@gmail.com");
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystem
                = new FileSystemResource(new File(attachment));

        mimeMessageHelper.addAttachment(fileSystem.getFilename(),
                fileSystem);

        List<Subscription> subscriptions = subscriptionService.getAll();
        for (Subscription s : subscriptions) {
            mimeMessageHelper.setTo(s.getEmailSubscriber());
            mailSender.send(mimeMessage);
        }
        System.out.println("Mail Send...");
    }

}
