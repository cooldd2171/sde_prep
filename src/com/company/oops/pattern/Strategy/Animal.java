package com.company.oops.pattern.Strategy;

public abstract class Animal{
    String color;
    String name;
    String weight;
    FlyInterface fly;

    public Animal(String color, String name, String weight) {
        this.color = color;
        this.name = name;
        this.weight = weight;
    }

    public void setFly(FlyInterface fly) {
        this.fly = fly;
    }

    public FlyInterface getFly() {
        return fly;
    }
}
