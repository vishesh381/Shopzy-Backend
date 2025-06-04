package com.ecommerce.project.service;

import com.ecommerce.project.model.MessageDTO;
import com.ecommerce.project.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendContactMessage(MessageDTO messageDTO) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(messageDTO.getEmail());
            helper.setSubject("Thank you for contacting us, " + messageDTO.getName() + "!");

            String emailContent = "Hi " + messageDTO.getName() + ",\n\n"
                    + "Thank you for reaching out to us. We have received your message and will get back to you shortly.\n\n"
                    + "Here is a copy of your message:\n"
                    + messageDTO.getMessage() + "\n\n"
                    + "Best regards,\n"
                    + "Vishesh Sharma";

            helper.setText(emailContent);

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Failed to send confirmation email: " + e.getMessage(), e);
        }
    }
}
