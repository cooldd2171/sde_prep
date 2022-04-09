package com.company.oops.pattern.Singleton;

public class SingletonService {
    public static void main(String[] args) {
        UserService userService = UserService.getInstance();
        System.out.println(userService.getMessage());
    }
}
