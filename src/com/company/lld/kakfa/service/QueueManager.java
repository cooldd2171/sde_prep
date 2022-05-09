package com.company.lld.kakfa.service;

import com.company.lld.kakfa.model.Subscriber;
import com.company.lld.kakfa.model.Topic;

public class QueueManager implements CustomQueue {

    @Override
    public Topic createTopic(Topic topic) {
        return null;
    }

    @Override
    public void pushMessage(Topic topic, String message) {
        
    }

    @Override
    public void addSubscriber(Topic topic, Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Topic topic, Subscriber subscriber) {

    }

    @Override
    public void resetOffset() {

    }
}
