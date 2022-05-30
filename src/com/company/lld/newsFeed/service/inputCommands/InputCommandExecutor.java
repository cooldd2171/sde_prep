package com.company.lld.newsFeed.service.inputCommands;

import com.company.lld.newsFeed.model.Post;
import com.company.lld.newsFeed.model.User;
import com.company.lld.newsFeed.service.enums.CommandExecutorEnum;
import com.company.lld.newsFeed.service.exeption.CustomException;

import java.util.List;

public abstract class InputCommandExecutor {
    List<Post> posts;
    List<User> users;
    User currentLoggedInUser;

    InputCommandExecutor(List<Post> posts, List<User> users, User currentLoggedInUser) {
        this.posts = posts;
        this.users = users;
        this.currentLoggedInUser = currentLoggedInUser;
    }

    public abstract String process(String input) throws CustomException;

    public abstract boolean validateInput(String input);

    public abstract CommandExecutorEnum getCommand();
}
