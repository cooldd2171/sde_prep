package com.company.lld.parking.service;

import com.company.lld.parking.model.Car;
import com.company.lld.parking.model.ParkingLot;
import com.company.lld.parking.model.Slot;

import java.util.List;
import java.util.Map;

public class ParkingRepo {
    List<Car> cars;
    List<Slot> slots;
    ParkingLot parkingLot;

    public ParkingRepo() {
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
