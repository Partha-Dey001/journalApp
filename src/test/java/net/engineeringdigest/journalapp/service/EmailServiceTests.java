package net.engineeringdigest.journalapp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    @Disabled
    public void sendEmailTest () {
        emailService.sendEmail("parthadeyofficial1@gmail.com",
                "Testing java mail sender",
                "Hi, How are you? \nRelax, this is just a dummy mail. I am testting java mailsender today for springboot.\nThank you.");
    }

}
