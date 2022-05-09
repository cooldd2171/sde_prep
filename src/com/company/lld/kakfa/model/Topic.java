package com.company.lld.kakfa.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private String name;
    private List<Message> messages;
    private List<Subscriber> subscribers;
    

    public Topic(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
