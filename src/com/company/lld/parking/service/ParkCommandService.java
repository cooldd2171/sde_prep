package com.company.lld.parking.service;

import com.company.lld.parking.enums.Color;
import com.company.lld.parking.enums.Command;
import com.company.lld.parking.model.Car;
import com.company.lld.parking.model.Slot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkCommandService<T> extends CommandService<T>{

    ParkingStrategy parkingStrategy;
    public ParkCommandService(ParkingRepo parkingRepo,ParkingStrategy parkingStrategy) {
        super(parkingRepo);
        this.parkingStrategy=parkingStrategy;
    }

    @Override
    public String execute(T input) {
        List<String> commandData = super.getCommandData(input);
        Slot slot = parkingStrategy.getNextSlot();
        slot.setAvailable(false);
        slot.setCar(new Car(Color.valueOf(commandData.get(0)),commandData.get(1)));
        return "Allocated slot number: "+slot.getSlotNumber();
    }

    @Override
    public boolean validate(T input) {
        return false;
    }

    @Override
    public Command get() {
        return Command.PARK_COMMAND;
    }
}
