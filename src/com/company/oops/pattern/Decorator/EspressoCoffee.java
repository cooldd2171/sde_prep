package com.company.oops.pattern.Decorator;

public class EspressoCoffee implements Beverage{
    @Override
    public String getName() {
        return "Espresso ";
    }

    @Override
    public double getCost() {
        return 2;
    }
}
