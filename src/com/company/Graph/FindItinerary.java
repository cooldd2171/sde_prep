package com.company.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class FindItinerary {

    public static void main(String[] args) {
        String[][] sample= {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<List<String>> list= Arrays.stream(sample).map(Arrays::asList).collect(Collectors.toList());
        findItinerary(list);
    }

    static Map<String, Set<String>> map;
    static List<String> answer;
    static long length;
    public static List<String> findItinerary(List<List<String>> tickets) {
         length=tickets.stream().mapToLong(Collection::size).sum();
        map=new HashMap<>();
        answer=new ArrayList<>();
        buildAdjacencyMap(tickets);
        dfs("JFK","JFK");
        return answer;
    }

    private static boolean dfs(String start,String source) {
        if(!source.equals("JFK") &&!map.get(source).contains("JFK")){
            return false;
        }
        Set<String> connections = map.get(start);
        if(answer.size()==length){
            return true;
        }
        answer.add(start);
        for (Iterator<String> iterator= connections.iterator();iterator.hasNext();){
            String val=iterator.next();
            connections.remove(val);
            map.put(source,connections);
            if(dfs(val,start)){
                return true;
            }
        }
        return false;
    }

    private static void buildAdjacencyMap(List<List<String>> tickets) {
        for (List<String> each: tickets){
            Set<String> connections=map.getOrDefault(each.get(0),new TreeSet<>());
            connections.add(each.get(1));
            map.put(each.get(0),connections);
        }
        
    }

}
