package com.company.lld.parking.service;

import com.company.lld.parking.enums.Command;
import com.company.lld.parking.exception.CommandNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommandStrategy {
    Map<Command,CommandService> map;

    public CommandStrategy(List<CommandService> commands) {
        map=commands.stream().collect(Collectors.toMap(CommandService::get, Function.identity()));
    }
    
    public CommandService getCommandService(String command){
        CommandService commandService = map.get(Command.get(command));
        if(Objects.isNull(commandService)){
            //throw error
        }
        return commandService;
    }
}
