package com.company.Graph;

import java.util.*;

public class TopologicalSort {
    
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<Integer> e2=new ArrayList<>();
        e2.add(3);
        e2.add(0);
        adj.add(e2);
        ArrayList<Integer> e3=new ArrayList<>();
        e3.add(1);
        e3.add(0);
        adj.add(e3);
        ArrayList<Integer> e4=new ArrayList<>();
        e4.add(2);
        e4.add(0);
        adj.add(e4);
        topoSort(4,adj);
    }

    static boolean[] visited;
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] answer=new  int[V];
        visited=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++){
                dfs(i,adj,stack);
            }
        int i=0;
        while (!stack.empty()){
            answer[i]=stack.pop();
            i++;
        }
        return answer;
    }

    private static void dfs(int v, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        if(visited[v]){
            return;
        }
        visited[v]=true;
        List<Integer> connections = adj.get(v);
        for(Integer each: connections){
            dfs(each,adj,stack);
        }
        stack.push(v);
    }

}
