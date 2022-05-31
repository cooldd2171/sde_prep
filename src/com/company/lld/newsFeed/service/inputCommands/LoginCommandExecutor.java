package com.company.lld.newsFeed.service.inputCommands;

import com.company.lld.newsFeed.model.Post;
import com.company.lld.newsFeed.model.User;
import com.company.lld.newsFeed.service.enums.CommandExecutorEnum;
import com.company.lld.newsFeed.service.exeption.CustomException;

import java.util.List;

public class LoginCommandExecutor extends InputCommandExecutor {

    public LoginCommandExecutor(List<Post> posts, List<User> users, User current) {
        super(posts, users, current);
    }

    @Override
    public String process(String input) throws CustomException {
        String[] split = input.split("~");
        String name = split[1];
        User user = users.stream().filter(e -> e.getName().equals(name)).findFirst().get();
        //super.currentLoggedInUser.setName(user.get().getName());
        super.currentLoggedInUser=user;
        return "User logged in";
    }

    @Override
    public boolean validateInput(String input) {
        String[] split = input.split("~");
        if (split.length < 2) {
            return false;
        }
        if (!split[0].equals("login")) {
            return false;
        }
        return true;
    }

    @Override
    public CommandExecutorEnum getCommand() {
        return CommandExecutorEnum.LOGIN;
    }
}
