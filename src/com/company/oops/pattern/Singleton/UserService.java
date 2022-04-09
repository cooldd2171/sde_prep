package com.company.oops.pattern.Singleton;

public class UserService {
    private static UserService userService;
    private static volatile String abc="";
    private UserService(){
    }
    
    public static UserService getInstance(){
        if(userService==null){
            synchronized (abc){
                userService=new UserService();
            }
        }
        return userService;
    }
    
    public String getMessage(){
        return "hey there!! I am singleton";
    }
}
