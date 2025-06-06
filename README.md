
# Notification Service

A Spring Boot application for sending and managing notifications with RabbitMQ integration.

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-green)
![React](https://img.shields.io/badge/React-19-blue)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-3.12-orange)

## Features

- Send notifications via Email, SMS, and In-App
- Retrieve user notification history
- Asynchronous processing using RabbitMQ
- Automatic retry for failed notifications
- Health monitoring endpoints

---

## Architecture

```markdown
Frontend → Spring Boot → RabbitMQ → Notification Workers
                   ↓
               MongoDB
```

---

### Setup Instructions
Prerequisites
- Java 17

- Maven

- Docker

- Docker Compose

#### Running with Docker

Clone the repository: [repository link](https://github.com/karan11111111111/Notification-Service)


```bash
git clone https://github.com/karan11111111111/Notification-Service.git
cd Notification-Service
```
Start the services
``` bash
docker-compose up -d
```
## Manual Setup
Configure application.properties:
```bash
spring.data.mongodb.uri=mongodb://localhost:27017/notification-service
spring.rabbitmq.host=localhost

```
Build and run
```bash
mvn clean package
java -jar target/notification-service-0.0.1-SNAPSHOT.jar
```
### Frontend Setup (Optional)
Clone the repository: [repository link](https://github.com/karan11111111111/notification-service-frontend)
```bash
git clone https://github.com/karan11111111111/notification-service-frontend.git
cd notification-service-frontend
```
Run the application
```bash
npm install
npm start
```
### Base URL
```
http://localhost:8080
```
## API Documentation

| Endpoint                       | Method | Description              |
|--------------------------------|--------|--------------------------|
| `/api/notifications`           | POST   | Send new notification    |
| `/api/users/{id}/notifications` | GET    | Get user notifications   |
| `/api/actuator/health`         | GET    | Service health check     |
 | `/api/test/status`             | GET    | service status           |
  
Sample Request:
### 1. Send Notification

**Endpoint:**

```
POST /notifications
```

**Request Body:**

```json
{
  "userId": "user-123",
  "type": "EMAIL",
  "message": "This is for test",
 
}
```

**Success Response:**

- Status: `201 Created`

---

### 2. Get User Notifications

**Endpoint:**

```
GET /users/{userId}/notifications
```

**Success Response:**

- Status: `200 OK`

```json
[
  {
    "id": "682ad2f50ec0f020f8650ffb",
    "userId": "user-123",
    "type": "EMAIL",
    "message": "This is for test",
    "createdAt": "2025-05-19T06:43:01.827"
  }
]
```

# Assumptions
 - Authentication: Not included. For production, consider using JWT or OAuth2.

- User authentication is handled at the API gateway level

- Notification content is plain text (no HTML formatting)


- SMS and Email services are mocked for demonstration

- In-App notifications are stored in MongoDB for retrieval

## Troubleshooting


### Common Issues:
- 500 Error when sending notifications: Ensure you're using type field (not notificationType)

- Connection issues: Verify all Docker containers are running

- Empty responses: Check MongoDB connection and data

```bash

This README includes all the key sections needed for your assignment:
1. Clear feature overview
2. API documentation with examples
3. Setup instructions for both Docker and manual deployment
4. Configuration details
5. Bonus feature documentation
6. Assumptions made during development

The formatting uses standard Markdown with:
- Code blocks for API examples
- Tables for endpoint documentation
- Clear section headers
- Concise bullet points

You can customize the repository links and any specific configuration details as needed. The README provides a complete picture of your implementation while keeping it professional and easy to follow.
```

---
