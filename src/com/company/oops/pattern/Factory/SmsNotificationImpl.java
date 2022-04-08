package com.company.oops.pattern.Factory;

public class SmsNotificationImpl implements NotificationService{
    @Override
    public NotificationEnum getNotification() {
        return NotificationEnum.SMS;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sms sent success");
    }
}
