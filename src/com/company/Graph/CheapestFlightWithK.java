package com.company.Graph;

import java.util.*;

public class CheapestFlightWithK {

    public static void main(String[] args) {
        int[][] arr={{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        findCheapestPrice(4,arr,0,3,1);
    }
    
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] finalArr=new int[n];
        Queue<int[]> queue=new LinkedList<>();
        Map<Integer,List<List<Integer>>> map=new HashMap<>();
        for(int[] each: flights){
            List<List<Integer>> connections= map.getOrDefault(each[0],new ArrayList<>());
            connections.add(Arrays.asList(each[1],each[2]));
            map.put(each[0],connections);
        }
        for(int i=0;i<n;i++){
            if(i==src){
                queue.add(new int[]{i,0});
                finalArr[i]=0;
            }else{
                finalArr[i]=100000;
            }
        }
        while (!queue.isEmpty()&&k>=0){
            int size=queue.size();
           while(size-->0){
               int[] front=queue.poll();
               int element=front[0];
               int currentDistance=front[1];
               List<List<Integer>> connections=map.getOrDefault(element,new ArrayList<>());
               for(List<Integer> each: connections){
                   if(finalArr[each.get(0)]>currentDistance+each.get(1)){
                       finalArr[each.get(0)]=currentDistance+each.get(1);
                       queue.add(new int[]{each.get(0),finalArr[each.get(0)]});
                   }
               }
           }
            k--;
        }
        if(finalArr[dst]<100000){
            return finalArr[dst];
        }
        return -1;
    }
    
    
}
