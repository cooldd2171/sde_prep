package com.company.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindEventualSafeStates {
    /*
    
    Problem Link::
    https://leetcode.com/problems/find-eventual-safe-states/
    
    */
    
    public static void main(String[] args) {

        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        eventualSafeNodes(graph);
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        visited=new boolean[graph.length];
        safeMap=new HashMap<>();
        globalVisited=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!safeMap.containsKey(i)){
                dfs(graph,i);
            }
        }
        List<Integer> answer = safeMap.entrySet().stream().filter(e -> e.getValue().equals(true)).map(Map.Entry::getKey).collect(Collectors.toList());
        return answer;
    }
    static boolean[] visited;
    static boolean[] globalVisited;
    static Map<Integer,Boolean> safeMap=new HashMap<>();
    public static boolean dfs(int[][] graph, int index){
        if(visited[index]){
            return true;
        }
        if(globalVisited[index]){
            return false;
        }
        globalVisited[index]=true;
        visited[index]=true;
        int[] connections = graph[index];
        for(Integer each: connections){
            if(dfs(graph,each)){
                safeMap.put(each,false);
                return true;
            }
        }
        visited[index]=false;
        if(!safeMap.containsKey(index)){
            safeMap.put(index,true);
        }
        return false;
    }
    
}
