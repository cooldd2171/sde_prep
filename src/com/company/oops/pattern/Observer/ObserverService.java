package com.company.oops.pattern.Observer;

import java.util.Arrays;
import java.util.List;

public class ObserverService {

    public static void main(String[] args) {
        WeatherInterface weatherInterface=new WeatherManager();
        HistoricalData historicalData=new HistoricalData();
        CurrentData currentData=new CurrentData();
        List<Display> displays= Arrays.asList(historicalData,currentData);
        weatherInterface.register(historicalData);
        weatherInterface.register(currentData);
        weatherInterface.updateData(new WeatherData(10,20,30));
        for(Display each: displays){
            each.display();
        }
        weatherInterface.updateData(new WeatherData(5,10,15));
        for(Display each: displays){
            each.display();
        }

    }
}
