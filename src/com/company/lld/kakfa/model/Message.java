package com.company.lld.kakfa.model;

import java.util.Date;

public class Message {
    String data;
    Date pushedAt;

    public Message(String data, Date pushedAt) {
        this.data = data;
        this.pushedAt = pushedAt;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(Date pushedAt) {
        this.pushedAt = pushedAt;
    }
}
