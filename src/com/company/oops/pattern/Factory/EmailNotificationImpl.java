package com.company.oops.pattern.Factory;

public class EmailNotificationImpl implements NotificationService{
    @Override
    public NotificationEnum getNotification() {
        return NotificationEnum.EMAIL;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Email sent successfully");
    }
    public void doNothing(){
        
    }
}
