package com.company.Graph;

import java.util.ArrayList;

public class GraphNumberOfPaths {
    
    public static void main(String[] args){

        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(3);
        list2.add(4);
        ArrayList<Integer> list3=new ArrayList<>();
        list3.add(4);
        ArrayList<Integer> list4=new ArrayList<>();
        list4.add(2);
       ArrayList<ArrayList<Integer>> arrayList=new ArrayList<>();
       arrayList.add(list1);
        arrayList.add(list2);
        arrayList.add(list3);
        arrayList.add(list4);


        countPaths(5,arrayList,0,4);
    }

    static int answer=0;
    public static int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                          int destination) {
        answer=0;
        boolean[] visited=new boolean[V];
        dfs(adj,source,destination,visited);
        return answer;
    }
    
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj,int source,int destination,boolean[] visited){
        if(source==destination){
            answer++;
            return true;
        }
        visited[source]=true;
        ArrayList<Integer> connections = adj.get(source);
        for(Integer each:connections){
            if(!visited[each])
            dfs(adj,each,destination,visited);
        }
        visited[source]=false;
        return false;
    }
    
}
