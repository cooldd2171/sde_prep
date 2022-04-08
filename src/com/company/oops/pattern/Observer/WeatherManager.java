package com.company.oops.pattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherManager implements WeatherInterface{

    List<Observer> observers;

    public WeatherManager() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void updateData(WeatherData weatherData) {
        for(Observer each: observers){
            each.update(weatherData);
        }
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void deRegister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public List<Observer> getObservers() {
        return this.observers;
    }
}
