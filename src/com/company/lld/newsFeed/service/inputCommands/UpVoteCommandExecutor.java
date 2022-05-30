package com.company.lld.newsFeed.service.inputCommands;

import com.shourya.demo.core.newsFeed.model.Post;
import com.shourya.demo.core.newsFeed.model.User;
import com.shourya.demo.core.newsFeed.service.enums.CommandExecutorEnum;

import java.util.List;

public class UpVoteCommandExecutor extends InputCommandExecutor {
    UpVoteCommandExecutor(List<Post> posts, List<User> users, User currentLoggedInUser) {
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
