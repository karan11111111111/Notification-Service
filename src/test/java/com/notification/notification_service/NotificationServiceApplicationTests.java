package com.notification.notification_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class NotificationServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5")
			.withReuse(true);

	@Container
	static RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq:3.12-management")
			.withReuse(true);

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
		registry.add("spring.rabbitmq.host", rabbitMQContainer::getHost);
		registry.add("spring.rabbitmq.port", rabbitMQContainer::getAmqpPort);
		registry.add("spring.rabbitmq.username", () -> "guest");
		registry.add("spring.rabbitmq.password", () -> "guest");
	}

	@Test
	void contextLoads() {
		// Test will pass if the application context loads
	}
}