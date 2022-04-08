package com.company.Graph;

import java.util.*;

public class GraphUndirectedCycle {
    
    
    public static void main(String[] args){
        List<Integer> zero=new ArrayList<>();
        List<Integer> one=Arrays.asList(2);
        List<Integer> two=Arrays.asList(1,3,4);
        List<Integer> three=Arrays.asList(2);
        List<Integer> four=Arrays.asList(2);
        List<List<Integer>> list=new ArrayList<>();
        list.add(zero);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        isCycle(5,list);
        
    }

    public static boolean isCycle(int V, List<List<Integer>> adj) {

        answer=false;
        visited=new boolean[V];
        for(int index=0;index<V;index++){
            if(!visited[index]){
                dfs(adj,index,index);
                if(answer){
                    return answer;
                }
            }
        }
       
        return answer;
        
    }
    
    static boolean answer=false;
    static boolean[] visited;
    public static void dfs(List<List<Integer>> adj,int index,int parent){
        
        visited[index]=true;
        List<Integer> connections = adj.get(index);
        for(Integer each: connections){
            if(!visited[each]){
                dfs(adj,each,index);
            }
            else if(each!=parent){
                    answer=true;
                }
        }
        
    }

}
