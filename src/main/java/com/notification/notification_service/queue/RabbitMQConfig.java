package com.notification.notification_service.queue;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE = "notificationQueue";
    public static final String EXCHANGE = "notification_exchange";
    public static final String ROUTING_KEY = "notification_routing_key";

    @Bean
    public Queue queue() {
        return QueueBuilder.durable(QUEUE)
                .deadLetterExchange("dlx.exchange")
                .deadLetterRoutingKey("dlx.routing.key")
                .build();
    }

    @Bean
    public Queue dlq() {
        return new Queue("notification.dlq");
    }

    @Bean
    public DirectExchange dlx() {
        return new DirectExchange("dlx.exchange");
    }

    @Bean
    public Binding dlxBinding() {
        return BindingBuilder.bind(dlq())
                .to(dlx())
                .with("dlx.routing.key");
    }
}