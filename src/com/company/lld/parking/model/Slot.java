package com.company.lld.parking.model;

public class Slot {
    private Car car;
    private Integer slotNumber;
    private boolean isAvailable;

    public Slot(Integer slotNumber) {
        this.slotNumber = slotNumber;
        this.isAvailable = true;
    }

    public Slot(Car car, Integer slotNumber) {
        this.car = car;
        this.slotNumber = slotNumber;
        this.isAvailable = true;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
