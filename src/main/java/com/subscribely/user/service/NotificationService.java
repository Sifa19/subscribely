package com.subscribely.user.service;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    public String sendNotification(String message) {
        // Logic to send notification
        return "Notification sent: " + message;
    }
}