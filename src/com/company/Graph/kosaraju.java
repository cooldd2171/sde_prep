package com.company.Graph;

import java.util.*;

public class kosaraju {

    static Stack<Integer> data;
    static boolean[] visited;
    
    public static void main(String[] args){
        ArrayList<List<Integer>> adj=new ArrayList<List<Integer>>();
        adj.add(Arrays.asList(1));
        data=new Stack<>();
        fun(adj,0,new boolean[100]);
        Map<Integer,List<Integer>> reverseGraphList=reverse(adj);
        visited=new boolean[100];
        int answer=0;
        while(!data.isEmpty()){
            Integer top = data.pop();
            if(!visited[top]){
                answer+=1;
                dfs(reverseGraphList,top);
            }
        }
    }

    public static void dfs(Map<Integer,List<Integer>> adj, int current){
        visited[current]=true;
        List<Integer> connections=adj.getOrDefault(current,new ArrayList<>());
        for(int i=0;i<connections.size();i++){
            if(!visited[connections.get(i)])
                dfs(adj,connections.get(i));
        }
    }

    private static Map<Integer,List<Integer>> reverse(ArrayList<List<Integer>> adj) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i=0;i<adj.size();i++){
            for(Integer each: adj.get(i)){
                List<Integer> connections=map.getOrDefault(each,new ArrayList<>());
                connections.add(i);
                map.put(each,connections);
            }
        }
        return map;
    }

    public static void fun(ArrayList<List<Integer>> adj, int current, boolean[] visited){
        visited[current]=true;
        if(current<adj.size()){
            List<Integer> connections=adj.get(current);
            for(int i=0;i<connections.size();i++){
                if(!visited[connections.get(i)])
                    fun(adj,connections.get(i),visited);
            } 
        }
        data.add(current);
    }


}
