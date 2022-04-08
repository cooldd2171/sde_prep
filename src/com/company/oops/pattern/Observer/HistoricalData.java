package com.company.oops.pattern.Observer;

public class HistoricalData implements Display,Observer{
    
    WeatherData weatherData;
    int count;

    public HistoricalData() {
        this.weatherData=new WeatherData(0,0,0);
    }

    @Override
    public void display() {
        System.out.println("Historical data:: humidity: "+this.weatherData.getHumidity()/count+" temperature: "+this.weatherData.getTemperature()/count+" windSpeed: "+this.weatherData.getWindSpeed()/count);
    }

    @Override
    public void update(WeatherData weatherData) {
        count++;
        int humidity=this.weatherData.getHumidity()+weatherData.getHumidity();
        int temperature=this.weatherData.getTemperature()+weatherData.getTemperature();
        int windSpeed=this.weatherData.getWindSpeed()+weatherData.getWindSpeed();
        this.weatherData.setHumidity(humidity);
        this.weatherData.setTemperature(temperature);
        this.weatherData.setWindSpeed(windSpeed);
    }
}
