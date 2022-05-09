package com.company.lld.parking.service;

import com.company.lld.parking.enums.Command;
import com.company.lld.parking.model.ParkingLot;
import com.company.lld.parking.model.Slot;

import java.util.ArrayList;
import java.util.List;

public class CreateSlotCommandService<T> extends CommandService<T> {

    int currentValue=0;
    public CreateSlotCommandService(ParkingRepo parkingRepo) {
        super(parkingRepo);
    }

    @Override
    public String execute(T input) {
        Integer capacity=(Integer) input;
        currentValue++;
        List<Slot> slots=new ArrayList<>();
        for(int iterator=1;iterator<=capacity;iterator++){
            slots.add(new Slot(iterator));
        }
        ParkingLot parkingLot = new ParkingLot(capacity, String.valueOf(currentValue));
        parkingLot.setCurrentCapacity(currentValue);
        parkingRepo.setSlots(slots);
        parkingRepo.setParkingLot(parkingLot);
        return String.valueOf(currentValue);
    }

    @Override
    public boolean validate(T input) {
        return input instanceof Integer;
    }

    @Override
    public Command get() {
        return Command.CREATE_PARKING_LOT_COMMAND;
    }
}
