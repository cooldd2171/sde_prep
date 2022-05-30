package com.company.lld.newsFeed.model;


import java.util.Set;

public class User {
    private String name;
    private Set<String> followers;

    public User(String name, Set<String> followers) {
        this.name = name;
        this.followers = followers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<String> followers) {
        this.followers = followers;
    }
}
