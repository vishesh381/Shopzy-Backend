package com.ecommerce.project.controller;

import com.ecommerce.project.model.MessageDTO;
import com.ecommerce.project.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO messageDTO) {
        emailService.sendContactMessage(messageDTO);
        return ResponseEntity.ok("Message sent successfully.");
    }
}
