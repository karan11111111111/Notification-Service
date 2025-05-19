package com.notification.notification_service.service;

import org.springframework.stereotype.Service;

@Service
public class SmsService {
    public void send(String userId, String message) {
        // TODO: Implement SMS logic (e.g., Twilio, AWS SNS, etc.)
        System.out.println("Sending SMS to user " + userId + ": " + message);
    }
}