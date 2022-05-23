package com.company.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class FindItinerary {

    public static void main(String[] args) {
        String[][] sample= {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<List<String>> list= Arrays.stream(sample).map(Arrays::asList).collect(Collectors.toList());
        findItinerary(list);
    }

    static Map<String, Set<Pair>> map;
    static List<String> answer;
    static long length;
    
    static class Pair implements Comparable<Pair>{
        String connection;
        boolean visited;

        public Pair(String connection, boolean visited) {
            this.connection = connection;
            this.visited = visited;
        }
        
        @Override
        public boolean equals(Object o){
            Pair p=(Pair) o;
            return p.connection.equals(this.connection);
        }


        @Override
        public int compareTo(Pair o) {
            return this.connection.compareTo(o.connection);
        }
    }
    
    public static List<String> findItinerary(List<List<String>> tickets) {
        long sum = 0L;
        for (List<String> ticket : tickets) {
            long size = ticket.size();
            sum += size;
        }
        length= sum;
        map=new HashMap<>();
        answer=new ArrayList<>();
        buildAdjacencyMap(tickets);
        dfs("JFK","JFK");
        return answer;
    }

    private static boolean dfs(String start,String source) {
        Set<Pair> pairs = map.get(start);
        boolean match=pairs.stream().anyMatch(e->e.connection.equals(source));
        if(!start.equals("JFK") &&!match){
            return false;
        }
        Set<Pair> connections = map.get(start);
        if(answer.size()==length){
            return true;
        }
        answer.add(start);
        if(connections==null){
            return false;
        }
        for (Pair each: connections){
            if(!each.visited){
                String val=each.connection;
                each.visited=true;
                if(dfs(val,start)){
                    return true;
                } 
            }
            
        }
        return false;
    }

    private static void buildAdjacencyMap(List<List<String>> tickets) {
        for (List<String> each: tickets){
            Set<Pair> connections=map.getOrDefault(each.get(0),new TreeSet<>());
            connections.add(new Pair(each.get(1),false));
            map.put(each.get(0),connections);
        }
        
    }

}
