package com.company.lld.kakfa.model;

public interface Subscriber {
    void consume(Message message);
}
