package com.company.lld.parking.enums;

import com.company.lld.parking.exception.CommandNotFoundException;

import java.util.Arrays;

public enum Command {
    CREATE_PARKING_LOT_COMMAND("create_parking_lot"),
    PARK_COMMAND("park"),
    LEAVE_COMMAND("leave"),
    STATUS_COMMAND("status"),
    REGISTRATION_NUMBER_COLOT("registration_numbers_for_cars_with_colour"),
    SLOT_NUMBER_CAR_COLOR("slot_numbers_for_cars_with_colour"),
    SLOT_NUMBER_REGISTRATION_NUMBER("slot_number_for_registration_number");
    
    String command;

    Command(String command) {
        this.command = command;
    }
    
    public static Command get(String command){
       return Arrays.stream(Command.values()).filter(e->e.command.equals(command)).findFirst().orElseThrow(CommandNotFoundException::new);
    }
}
