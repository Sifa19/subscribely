package com.subscribely.notification;

import com.subscribely.notification.service.NotificationService;
import org.springframework.stereotype.Service;


@Service("SmsNotificationService")
class SmsNotificationService implements NotificationService {
    @Override
    public String sendNotification(String message) {
        // Logic to send SMS notification
        return "SMS notification sent: " + message;
    }
}