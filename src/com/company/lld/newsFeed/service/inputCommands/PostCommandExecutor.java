package com.company.lld.newsFeed.service.inputCommands;


import com.company.lld.newsFeed.model.Post;
import com.company.lld.newsFeed.model.User;
import com.company.lld.newsFeed.service.enums.CommandExecutorEnum;

import java.util.Date;
import java.util.List;

public class PostCommandExecutor extends InputCommandExecutor {
    int id;
    public PostCommandExecutor(List<Post> posts, List<User> users, User currentLoggedInUser) {
        super(posts, users, currentLoggedInUser);
    }

    @Override
    public String process(String input) {
        String[] split = input.split("~");
        String content=split[1];
        Post post=new Post();
        post.setId(++id);
        post.setText(content);
        post.setCreatedAt(new Date());
        post.setCreatedBy(currentLoggedInUser);
        posts.add(post);
        return "Post created success";
    }

    @Override
    public boolean validateInput(String input) {
        String[] split = input.split("~");
        if(super.currentLoggedInUser==null){
            return false;
        }
        if (split.length < 2) {
            return false;
        }
        if (!split[0].equals("post")) {
            return false;
        }
        return true;

    }

    @Override
    public CommandExecutorEnum getCommand() {
        return CommandExecutorEnum.POST;
    }
}
