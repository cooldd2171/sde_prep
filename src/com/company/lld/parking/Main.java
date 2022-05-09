package com.company.lld.parking;

import com.company.lld.parking.service.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {

        ParkingRepo parkingRepo=new ParkingRepo();
        List<CommandService> commandServices= Arrays.asList(new CreateSlotCommandService(parkingRepo),new ParkCommandService(parkingRepo,new NearestParkingSlotStrategy()));
        CommandStrategy commandStrategy=new CommandStrategy(commandServices);
        String command1="";
        CommandService commandService = commandStrategy.getCommandService(command1);
        commandService.validate(command1);
        commandService.execute(command1);
    }
}
