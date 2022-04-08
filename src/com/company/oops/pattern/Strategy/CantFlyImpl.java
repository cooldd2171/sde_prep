package com.company.oops.pattern.Strategy;

public class CantFlyImpl implements FlyInterface{
    @Override
    public String fly() {
        return "I cannot fly";
    }
}
