package com.tejasvivermani.module1Introduction.impl;

import com.tejasvivermani.module1Introduction.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("emailNotification")
@ConditionalOnProperty(name="notification.type", havingValue = "EMAIL")
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email for : "+message);
    }
}
