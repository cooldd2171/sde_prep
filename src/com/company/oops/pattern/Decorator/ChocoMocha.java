package com.company.oops.pattern.Decorator;

public class ChocoMocha extends Flavour{
    

    public ChocoMocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getName() {
        return this.beverage.getName()+"chocoMocha ";
    }

    @Override
    public double getCost() {
        return this.beverage.getCost()+0.5;
    }
}
