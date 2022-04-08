package com.company.oops.pattern.Strategy;

public class Bird extends Animal{
    public Bird(String color, String name, String weight) {
        super(color, name, weight);
        setFly(new CantFlyImpl());
    }
}
