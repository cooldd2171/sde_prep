package com.company.oops.pattern.Factory;

import java.util.Arrays;

public class FactoryService {
    public static void main(String[] args){
        NotificationHelper notificationHelper=new NotificationHelper(Arrays.asList(new SmsNotificationImpl(),new EmailNotificationImpl()));
        NotificationService notification = notificationHelper.getNotification(NotificationEnum.EMAIL);
        notification.sendNotification("Your order is successfully placed. Please visit again!");
    }
}
