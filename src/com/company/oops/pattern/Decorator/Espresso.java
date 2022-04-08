package com.company.oops.pattern.Decorator;

public class Espresso implements Beverage{
    @Override
    public String getName() {
        return "Espresso ";
    }

    @Override
    public double getCost() {
        return 2;
    }
}
