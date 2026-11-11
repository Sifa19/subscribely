package com.subscribely.user.controller;

import com.subscribely.notification.service.NotificationService;
import com.subscribely.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Qualifier;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    private final UserService userService;
    private final NotificationService notificationService;

    public UserController(UserService userService,@Qualifier("SmsNotificationService") NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }


    @GetMapping("/")
    public String home() {
        return "Welcome to the Subscribely API!";
    }

    @GetMapping("/name")
    public String getUserName() {
        return userService.getUserName();
    }

    @GetMapping("/notify")
    public String sendNotification() {
        String message = "This is a test notification.";
        return notificationService.sendNotification(message);
    }
}