package com.company.lld.parking.service;

import com.company.lld.parking.model.Slot;

public interface ParkingStrategy {
    Slot getNextSlot();
}
