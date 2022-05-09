package com.company.lld.kakfa.service;

import com.company.lld.kakfa.model.Subscriber;
import com.company.lld.kakfa.model.Topic;

public interface CustomQueue {
    Topic createTopic(Topic topic);
    void pushMessage(Topic topic,String message);
    void addSubscriber(Topic topic, Subscriber subscriber);
    void removeSubscriber(Topic topic, Subscriber subscriber);
    void resetOffset();
}
