package com.company.oops.pattern.Strategy;

public class StrategyRun {
    
    public static void main(String[] args){
        Animal dog=new Dog("black","german","20kg");
        System.out.println("dog can: "+dog.getFly().fly());
        dog.setFly(new CanFlyImpl());
        System.out.println("dog can: "+dog.getFly().fly());
    }
    
}
