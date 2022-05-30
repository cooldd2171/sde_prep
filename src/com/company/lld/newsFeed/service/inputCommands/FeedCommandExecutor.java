package com.company.lld.newsFeed.service.inputCommands;



import com.company.lld.newsFeed.model.Post;
import com.company.lld.newsFeed.model.User;
import com.company.lld.newsFeed.service.enums.CommandExecutorEnum;
import com.company.lld.newsFeed.service.sort.SortingFilter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FeedCommandExecutor extends InputCommandExecutor{
    SortingFilter sortingFilter;

    public FeedCommandExecutor(List<Post> posts, List<User> users, User currentLoggedInUser, SortingFilter sortingFilter) {
        super(posts, users, currentLoggedInUser);
        this.sortingFilter = sortingFilter;
    }

    @Override
    public String process(String input) {
        Set<String> followers = currentLoggedInUser.getFollowers();
        List<Post> userFeed = posts.stream().filter(e -> followers.contains(e.getCreatedBy().getName())).collect(Collectors.toList());
        return sortingFilter.sort(userFeed).toString();
    }

    @Override
    public boolean validateInput(String input) {
        String[] split=input.split("~");
        if(currentLoggedInUser.getName()==null){
            return false;
        }
        if(split.length<2){
            return false;
        }
        if(!split[0].equals("feed")){
            return false;
        }
        return true;
    }

    @Override
    public CommandExecutorEnum getCommand() {
        return CommandExecutorEnum.FEED;
    }
}
