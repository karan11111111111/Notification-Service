package com.notification.notification_service.service;

import com.notification.notification_service.dto.NotificationRequest;
import com.notification.notification_service.model.Notification;
import com.notification.notification_service.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {





    @Autowired
    private NotificationRepository repository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SmsService smsService;

    public void sendNotification(NotificationRequest request) {
        // Save to DB
        Notification notification = new Notification();
        notification.setUserId(request.getUserId());
        notification.setType(request.getType());
        notification.setMessage(request.getMessage());
        notification.setCreatedAt(LocalDateTime.now());
        repository.save(notification);

        // Send notification based on type
        switch (request.getType().toUpperCase()) {
            case "EMAIL":
                emailService.send(request.getUserId(), request.getMessage());
                break;
            case "SMS":
                smsService.send(request.getUserId(), request.getMessage());
                break;
            case "IN_APP":
                // Handle in-app notifications (e.g., WebSocket, Firebase)
                break;
            default:
                throw new IllegalArgumentException("Invalid notification type: " + request.getType());
        }
    }

    public List<Notification> getNotifications(String userId) {
        return repository.findByUserId(userId);
    }
}
