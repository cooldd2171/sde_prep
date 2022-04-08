package com.company.oops.pattern.Factory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NotificationHelper {
    public Map<NotificationEnum,NotificationService> map;
    public List<NotificationService> items;

    public NotificationHelper(List<NotificationService> items) {
        map=items.stream().collect(Collectors.toMap(NotificationService::getNotification, Function.identity()));
    }
    
    public NotificationService getNotification(NotificationEnum notificationEnum){
        return map.get(notificationEnum);
    }
}
