package com.kyougaru.jms.consumer.service;

import com.kyougaru.model.Email;
import com.kyougaru.model.User;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
    @JmsListener(destination = "sendMail")
    public void sendMailToNewUser(User user) {
        var email = new Email(user.getEmail(), "Seu cadastro foi realizado com sucesso " + user.getName() + "!");
        System.out.println("Sending mail to <" + email + ">");
    }
}
