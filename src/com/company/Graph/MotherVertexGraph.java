package com.company.Graph;

import java.util.*;

public class MotherVertexGraph {
    
    boolean[] visited;
    
    public static void main(String[] args){
        
    }

    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int answer=Integer.MAX_VALUE;
        visited=new boolean[V];
        for(int i=0;i<V;i++){
            visited=new boolean[V];
            dfs(adj,0);
            boolean b = checkBoolean(visited);
            if(b)
            answer=Math.min(answer,i);
        }
        return answer;
    }

    private boolean checkBoolean(boolean[] visited) {
        for(boolean each: visited){
            if(!each){
                return false;
            }
        }
        return true;
    }

    void dfs( ArrayList<ArrayList<Integer>> adj,int index){
        if(visited[index]){
            return ;
        }
        visited[index]=true;
        ArrayList<Integer> list = adj.get(index);
        for(Integer each:list){
            if(!visited[each])
            dfs(adj,each);
        }
    }
    
    //stack top will give the answer
    void dfs(ArrayList<ArrayList<Integer>> adj, int index, Stack<Integer> stack){
        if(visited[index]){
            return;
        }
        visited[index]=true;
        ArrayList<Integer> connections = adj.get(index);
        for(Integer each: connections){
            dfs(adj,each,stack);
        }
        stack.push(index);
    }
}
