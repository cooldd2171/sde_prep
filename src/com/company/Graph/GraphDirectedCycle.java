package com.company.Graph;

import java.util.ArrayList;

public class GraphDirectedCycle {

    public static void main(String[] args) {


    }

    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> list1) {
        
        boolean[] visited=new boolean[N];
        boolean[] globalVisited=new boolean[N];

        for(int i=0;i<N;i++){
            if(cyclicUtil(0,list1,visited,globalVisited)){
                return true;
            }
        }
        return false;

    }

    private boolean cyclicUtil(int current,ArrayList<ArrayList<Integer>> list, boolean[] visited, boolean[] globalVisited) {
        
        if(visited[current]){
            return true;
        }
        if(globalVisited[current]){
            return false;
        }
        visited[current]=true;
        globalVisited[current]=true;

        ArrayList<Integer> connections = list.get(current);
        
        for(int i=0;i<connections.size();i++){
            if(cyclicUtil(connections.get(i),list,visited,globalVisited)){
                return true;
            }
        }
        
        visited[current]=false;
        return false;
        
    }


}
