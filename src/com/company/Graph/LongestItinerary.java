package com.company.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LongestItinerary {

    public static void main(String[] args) {
        
    }
    
    static class FlightInfo{
        String destination;
        int flightCost;
        int hotelCost;
        int date;

        public FlightInfo(String destination, int flightCost, int hotelCost, int date) {
            this.destination = destination;
            this.flightCost = flightCost;
            this.hotelCost = hotelCost;
            this.date = date;
        }
        
    }
    
    static int endDate;
    static int totalAmount;
    static String endPoint;
    static List<String> resultPath;
    
    public static void compute(Map<String,List<FlightInfo>> flightInfoMap, String src, String dest, int currentPrice, int currentDate, List<String> path){
        if(currentDate>endDate){
            return;
        }
        if(currentPrice>totalAmount){
            return;
        }
        path.add(src);
        if(dest.equals(endPoint) && path.size()>1){
            if(path.size()>resultPath.size()){
                resultPath=new ArrayList<>(path);
            }
            path.remove(path.size()-1);
            return;
        }
        List<FlightInfo> connections=flightInfoMap.get(src);
        for(FlightInfo each: connections){
            int newPrice=currentPrice+each.flightCost + (each.date-currentDate) * each.hotelCost;
            int newDate=currentDate+each.date;
            compute(flightInfoMap,each.destination,dest,newPrice,newDate,path);
        }
        path.remove(path.size()-1);
    }
}
