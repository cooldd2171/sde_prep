package com.company.lld.parking.model;

public class ParkingLot {
    private int capacity;
    private int currentCapacity;
    private String lotId;

    public ParkingLot(int capacity, String lotId) {
        this.capacity = capacity;
        this.lotId = lotId;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }
}
