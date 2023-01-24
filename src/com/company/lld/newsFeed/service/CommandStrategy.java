package com.company.lld.newsFeed.service;

import com.company.lld.newsFeed.service.enums.CommandExecutorEnum;
import com.company.lld.newsFeed.service.inputCommands.InputCommandExecutor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommandStrategy {
    Map<CommandExecutorEnum, InputCommandExecutor> map=new HashMap<>();

    public CommandStrategy(List<InputCommandExecutor> executors) {
        map=executors.stream().collect(Collectors.toMap(InputCommandExecutor::getCommand, Function.identity()));
    }
    
    
    public InputCommandExecutor get(String name){
        return map.get(Arrays.stream(CommandExecutorEnum.values()).filter(e->e.name().equalsIgnoreCase(name)).findFirst().get());
    }
}
