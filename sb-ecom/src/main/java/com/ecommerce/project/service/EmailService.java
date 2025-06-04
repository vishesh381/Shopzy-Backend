package com.ecommerce.project.service;

import com.ecommerce.project.model.MessageDTO;

public interface EmailService {
    void sendContactMessage(MessageDTO messageDTO);
}
