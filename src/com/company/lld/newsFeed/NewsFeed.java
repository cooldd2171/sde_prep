package com.company.lld.newsFeed;

import com.company.lld.newsFeed.model.Post;
import com.company.lld.newsFeed.model.User;
import com.company.lld.newsFeed.service.CommandStrategy;
import com.company.lld.newsFeed.service.exeption.CustomException;
import com.company.lld.newsFeed.service.inputCommands.*;
import com.company.lld.newsFeed.service.sort.DefaultSortingFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NewsFeed {

    public static void main(String[] args) {
        
        String text="";
        Scanner scanner=new Scanner(System.in);
        List<Post> posts=new ArrayList<>();
        List<User> users=new ArrayList<>();
        User currentUser=null;
        
        CommandStrategy commandStrategy=new CommandStrategy(Arrays.asList(new DownVoteCommandExecutor(posts,users,currentUser),
                new FeedCommandExecutor(posts,users,currentUser,new DefaultSortingFilter()),
                new SignUpCommandExecutor(posts,users,currentUser),
                new LoginCommandExecutor(posts,users,currentUser),
                new FollowCommandExecutor(posts,users,currentUser),
                new PostCommandExecutor(posts,users,currentUser)));
        while(true){
            text=scanner.next();
            if(text.equals("exit")){
                break;
            }
            try {
                InputCommandExecutor inputCommandExecutor = commandStrategy.get(text.split("~")[0]);
                if(!inputCommandExecutor.validateInput(text)){
                    throw new CustomException("invalid input");
                }
                System.out.println(inputCommandExecutor.process(text));
            }catch (Exception exception){
                System.out.println("input is incorrect");
            }
        }
    }
    
}
