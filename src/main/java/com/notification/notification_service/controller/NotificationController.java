package com.notification.notification_service.controller;



import com.notification.notification_service.dto.NotificationRequest;
import com.notification.notification_service.model.Notification;
import com.notification.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationController {
    @Autowired
    private NotificationService service;
    @PostMapping("/notifications")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        service.sendNotification(request);
        return ResponseEntity.ok("Notification sent successfully");
    }
    @GetMapping("/users/{userId}/notifications")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable String userId) {
        return ResponseEntity.ok(service.getNotifications(userId));
    }
}
