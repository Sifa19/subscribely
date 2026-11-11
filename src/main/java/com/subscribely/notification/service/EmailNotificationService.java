package com.subscribely.notification;
import com.subscribely.notification.service.NotificationService;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;

@Service("EmailNotificationService")
@Primary
class EmailNotificationService implements NotificationService {
    @Override
    public String sendNotification(String message) {
        // Logic to send email notification
        return "Email notification sent: " + message;
    }
}