package com.subscribely.config;

// import com.subscribely.user.service.NotificationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.subscribely.learning.lifecycle.DemoBean;

@Configuration
public class AppConfig {
    // Configuration settings for the application

    // @Bean
    // public NotificationService notificationService() {
    //     return new NotificationService();
    // }

    @Bean(initMethod = "initDemoBean", destroyMethod = "destroyDemoBean")
    public DemoBean demoBean() {
        return new DemoBean();
    }
}