package com.company.lld.parking.model;

import com.company.lld.parking.enums.Color;

public class Car {
    private Color number;
    private String color;

    public Car(Color number, String color) {
        this.number = number;
        this.color = color;
    }

    public Color getNumber() {
        return number;
    }

    public void setNumber(Color number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
