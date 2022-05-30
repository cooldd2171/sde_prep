package com.company.lld.newsFeed.service.inputCommands;

import com.company.lld.newsFeed.model.Post;
import com.company.lld.newsFeed.model.User;
import com.company.lld.newsFeed.service.enums.CommandExecutorEnum;

import java.util.List;

public class ReplyCommandExecutor extends InputCommandExecutor {
    ReplyCommandExecutor(List<Post> posts, List<User> users, User currentLoggedInUser) {
        super(posts, users, currentLoggedInUser);
    }

    @Override
    public String process(String input) {
        return null;
    }

    @Override
    public boolean validateInput(String input) {
return true;
    }

    @Override
    public CommandExecutorEnum getCommand() {
        return null;
    }
}
