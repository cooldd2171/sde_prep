package com.company.lld.newsFeed.service.inputCommands;

import com.company.lld.newsFeed.model.Post;
import com.company.lld.newsFeed.model.User;
import com.company.lld.newsFeed.service.enums.CommandExecutorEnum;

import java.util.List;

public class DownVoteCommandExecutor extends InputCommandExecutor {

    public DownVoteCommandExecutor(List<Post> posts, List<User> users, User currentLoggedInUser) {
        super(posts, users, currentLoggedInUser);
    }

    @Override
    public String process(String input) {
        return null;
    }

    @Override
    public boolean validateInput(String input) {
        String[] split=input.split("~");
        if(split.length<2){
            return false;
        }
        if(!split[0].equals("downvote")){
            return false;
        }
        try {
            Integer.parseInt(split[1]);
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }

    @Override
    public CommandExecutorEnum getCommand() {
        return CommandExecutorEnum.DOWN_VOTE;
    }
}
