package com.company.oops.pattern.Observer;

public class CurrentData implements Observer,Display{
    
    WeatherData weatherData;

    public CurrentData() {
        this.weatherData=new WeatherData(0,0,0);
    }

    @Override
    public void display() {
        System.out.println("Current data:: "+weatherData.toString());
    }

    @Override
    public void update(WeatherData weatherData) {
        this.weatherData=weatherData;
    }
}
