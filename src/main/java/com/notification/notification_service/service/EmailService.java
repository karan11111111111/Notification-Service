package com.notification.notification_service.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void send(String userId, String message) {
        // TODO: Implement email logic (e.g., using JavaMailSender, SendGrid, etc.)
        System.out.println("Sending EMAIL to user " + userId + ": " + message);
    }
}