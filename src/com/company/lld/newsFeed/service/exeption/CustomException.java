package com.company.lld.newsFeed.service.exeption;

public class CustomException extends RuntimeException{
    private String message;

    public CustomException(String message) {
        this.message = message;
    }
}
