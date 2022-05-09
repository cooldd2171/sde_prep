package com.company.lld.parking.exception;

public class CommandNotFoundException extends RuntimeException{

    public CommandNotFoundException() {
        super("Command Not Found Exception");
    }
}
