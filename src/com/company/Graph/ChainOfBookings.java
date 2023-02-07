package com.company.Graph;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChainOfBookings {

    static class Booking {
        int userId;
        int resId;
        int checkIn;
        int checkOut;

        public Booking(int userId, int resId, int checkIn, int checkOut) {
            this.userId = userId;
            this.resId = resId;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getResId() {
            return resId;
        }

        public void setResId(int resId) {
            this.resId = resId;
        }

        public int getCheckIn() {
            return checkIn;
        }

        public void setCheckIn(int checkIn) {
            this.checkIn = checkIn;
        }

        public int getCheckOut() {
            return checkOut;
        }

        public void setCheckOut(int checkOut) {
            this.checkOut = checkOut;
        }
    }
    
    static class ReserveInfo{
        int resId;
        int checkout;

        public ReserveInfo(int resId, int checkout) {
            this.resId = resId;
            this.checkout = checkout;
        }

        public int getResId() {
            return resId;
        }
        

        public int getCheckout() {
            return checkout;
        }

        public void setResId(int resId) {
            this.resId = resId;
        }

        public void setCheckout(int checkout) {
            this.checkout = checkout;
        }
    }
    
    public static void main(String[] args) {

        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking(1, 1001, 100, 101));
        bookings.add(new Booking(2, 1002, 104, 105));
        bookings.add(new Booking(1, 1003, 101, 103));
        bookings.add(new Booking(3, 1004, 104, 105));
        bookings.add(new Booking(3, 1005, 105, 107));
        bookings.add(new Booking(4, 1006, 106, 108));
        bookings.add(new Booking(4, 1007, 108, 110));
        bookings.add(new Booking(4, 1008, 108, 109));
        bookings.add(new Booking(4, 1009, 110, 112));
        bookings.add(new Booking(4, 1010, 109, 113));
        
        Map<Integer,List<Booking>> userIdToBookingMap=bookings.stream().collect(Collectors.groupingBy(Booking::getUserId));
        Map<Integer,List<List<Integer>>> answer=new HashMap<>();
        for(Map.Entry<Integer,List<Booking>> entry: userIdToBookingMap.entrySet()){
            List<Booking> values = entry.getValue();
            Map<Integer,List<ReserveInfo>> conn=values.stream().collect(Collectors.groupingBy(Booking::getCheckIn,Collectors.mapping(e->new ReserveInfo(e.getResId(),e.getCheckOut()),Collectors.toList())));
            TreeMap<Integer,List<ReserveInfo>> connections=new TreeMap<>(conn);
            Integer source=connections.firstEntry().getKey();
            List<Integer> path=new ArrayList<>();
            result=new ArrayList<>();

            process(connections,source,path);
            answer.put(entry.getKey(),result);
        }
        System.out.println(answer);
    }
    static List<List<Integer>> result;
    static void process(TreeMap<Integer,List<ReserveInfo>> connections,Integer source,List<Integer> path){
        if(!connections.containsKey(source)&&path.size()>1){
            result.add(new ArrayList<>(path));
            return;
        }
        List<ReserveInfo> reserveInfos=connections.getOrDefault(source,new ArrayList<>());
        for(ReserveInfo each: reserveInfos){
            path.add(each.resId);
            process(connections,each.checkout,path);
            path.remove(path.size()-1);
        }
    }
}
