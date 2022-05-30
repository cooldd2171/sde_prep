package com.company.lld.newsFeed.service.inputCommands;

import com.company.lld.newsFeed.model.Post;
import com.company.lld.newsFeed.model.User;
import com.company.lld.newsFeed.service.enums.CommandExecutorEnum;


import java.util.HashSet;
import java.util.List;

public class SignUpCommandExecutor extends InputCommandExecutor {
    public SignUpCommandExecutor(List<Post> posts, List<User> users, User current) {
        super(posts,users,current);
    }

    @Override
    public String process(String input) {
        String[] split=input.split("~");
        String name=split[1];
        //TODO:: add check for adding a new user
        User user=new User(name,new HashSet<>());
        users.add(user);
        return "User added successfully";
    }

    @Override
    public boolean validateInput(String input) {
        String[] split=input.split("~");
        if(split.length<2){
            return false;
        }
        if(!split[0].equals("signup")){
            return false;
        }
        return true;
    }

    @Override
    public CommandExecutorEnum getCommand() {
        return CommandExecutorEnum.SIGNUP;
    }
}
