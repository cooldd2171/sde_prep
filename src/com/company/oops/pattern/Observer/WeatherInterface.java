package com.company.oops.pattern.Observer;

import java.util.ArrayList;
import java.util.List;

public interface WeatherInterface {
    void updateData(WeatherData weatherData);
    void register(Observer observer);
    void deRegister(Observer observer);
    public List<Observer> getObservers();
}
