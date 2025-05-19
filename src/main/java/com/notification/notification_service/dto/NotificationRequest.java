package com.notification.notification_service.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NotificationRequest {

    private String userId;

    private String type;

    private String message;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}