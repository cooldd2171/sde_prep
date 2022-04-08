package com.company.oops.pattern.Decorator;

public class Mint extends Flavour{

    public Mint(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getName() {
        return this.beverage.getName()+" mint ";
    }

    @Override
    public double getCost() {
        return this.beverage.getCost() + 0.2;
    }
}
