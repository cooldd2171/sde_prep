package com.company.oops.pattern.Factory;

public interface NotificationService {
    NotificationEnum getNotification();
    void sendNotification(String message);
}
