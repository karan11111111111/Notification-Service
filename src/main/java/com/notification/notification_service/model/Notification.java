package com.notification.notification_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;
    private String userId;
    private String type; // EMAIL, SMS, IN_APP
    private String message;
    private LocalDateTime createdAt;
}