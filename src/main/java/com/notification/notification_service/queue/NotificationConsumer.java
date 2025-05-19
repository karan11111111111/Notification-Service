package com.notification.notification_service.queue;

import com.notification.notification_service.dto.NotificationRequest;
import com.notification.notification_service.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    private final NotificationService service;

    public NotificationConsumer(NotificationService service) {
        this.service = service;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void handleNotification(NotificationRequest request) {
        service.sendNotification(request);
    }
}