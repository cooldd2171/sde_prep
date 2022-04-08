package com.company.oops.pattern.Decorator;

public class DarkRoastCoffee implements Beverage{
    @Override
    public String getName() {
        return "Dark Roast ";
    }

    @Override
    public double getCost() {
        return 1;
    }
}
