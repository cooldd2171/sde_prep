package com.company.oops.pattern.Decorator;

public abstract class Flavour implements Beverage {
    protected Beverage beverage;

    public Flavour(Beverage beverage) {
        this.beverage = beverage;
    }
}
