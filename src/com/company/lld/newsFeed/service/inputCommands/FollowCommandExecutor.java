package com.company.lld.newsFeed.service.inputCommands;


import com.company.lld.newsFeed.model.Post;
import com.company.lld.newsFeed.model.User;
import com.company.lld.newsFeed.service.enums.CommandExecutorEnum;

import java.util.List;
import java.util.Set;

public class FollowCommandExecutor extends InputCommandExecutor {
    public FollowCommandExecutor(List<Post> posts, List<User> users, User currentLoggedInUser) {
        super(posts, users, currentLoggedInUser);
    }

    @Override
    public String process(String input) {
        String[] split = input.split("~");
        String userName=split[1];
        Set<String> followerMap = currentLoggedInUser.getFollowers();
        followerMap.add(userName);
        return "user followed success";
    }

    @Override
    public boolean validateInput(String input) {
        String[] split = input.split("~");
        if(currentLoggedInUser==null){
            return false;
        }
        if (split.length < 2) {
            return false;
        }
        if (!split[0].equals("follow")) {
            return false;
        }
        String userName=split[1];
        if(users.stream().noneMatch(e->e.getName().equals(userName))){
            return false;
        }

        return true;
    }

    @Override
    public CommandExecutorEnum getCommand() {
        return CommandExecutorEnum.FOLLOW;
    }
}
