package com.company.oops.pattern.Strategy;

public class Dog extends Animal{
    public Dog(String color, String name, String weight) {
        super(color, name, weight);
        setFly(new CantFlyImpl());
    }
}
