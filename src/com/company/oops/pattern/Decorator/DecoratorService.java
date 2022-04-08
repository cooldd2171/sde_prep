package com.company.oops.pattern.Decorator;

public class DecoratorService {
    
    public static void main(String[] args) {
       Beverage beverage=new DarkRoastCoffee();
       beverage=new ChocoMocha(beverage);
       beverage=new ChocoMocha(beverage);
       beverage=new Mint(beverage);
      System.out.println("name: "+beverage.getName()+"cost: $"+beverage.getCost());
    }
    
}
