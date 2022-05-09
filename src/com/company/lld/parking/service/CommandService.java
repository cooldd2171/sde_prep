package com.company.lld.parking.service;


import com.company.lld.parking.enums.Command;

import java.util.Arrays;
import java.util.List;

public abstract class CommandService<T> {
    ParkingRepo parkingRepo;

    public CommandService(ParkingRepo parkingRepo) {
        this.parkingRepo = parkingRepo;
    }
    
    public List<String> getCommandData(T input){
        String data=(String) input;
        String[] splitData = data.split(" ");
        List<String> inputData= Arrays.asList(splitData);
        inputData.remove(0);
        return inputData;
    }
    
    public abstract String execute(T input);
    public abstract boolean validate(T input);
    public abstract Command get();
}
