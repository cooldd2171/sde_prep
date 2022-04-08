package com.company.oops.pattern.Observer;

import com.sun.tools.corba.se.idl.InterfaceGen;

public class WeatherData {
    private Integer temperature;
    private Integer humidity;
    private Integer windSpeed;

    public WeatherData(Integer temperature, Integer humidity, Integer windSpeed) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                '}';
    }
}
