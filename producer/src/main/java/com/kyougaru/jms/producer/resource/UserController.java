package com.kyougaru.jms.producer.resource;

import com.kyougaru.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody User user) {
        //Persiste os dados etc
        //Envia uma mensagem para a api de email com os dados do usuário
        jmsTemplate.convertAndSend("sendMail", user);
        return ResponseEntity.ok().build();
    }
}
