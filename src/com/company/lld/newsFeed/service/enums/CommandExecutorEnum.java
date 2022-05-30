package com.company.lld.newsFeed.service.enums;

public enum CommandExecutorEnum {
    LOGIN("login"),
    SIGNUP("signup"),
    POST("post"),
    FOLLOW("follow"),
    REPLY("reply"),
    UP_VOTE("upvote"),
    DOWN_VOTE("downvote"),
    FEED("feed");
    
    private String name;

    CommandExecutorEnum(String name) {
        this.name = name;
    }
}
