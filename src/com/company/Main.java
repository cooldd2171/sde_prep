package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static boolean isCyclic(int N, ArrayList<List<Integer>> list1)
    {
       ArrayList<List<Integer>> adj=new ArrayList<>();
       for(int i=0;i<N;i++){
           ArrayList<Integer> arr=new ArrayList<>();
           arr.add(i);
           arr.addAll(list1.get(i));
           adj.add(arr);
       }
        boolean[] globalVisited =new boolean[N+1];
        for(List<Integer> list: adj){
            boolean[] visited =new boolean[N+1];
            boolean result=cyclicUtil(list.get(0),adj,globalVisited,visited);
            if(result){
                return true;
            }
        }
       
        
        return false;
    }



    private static boolean cyclicUtil(int current, ArrayList<List<Integer>> adj, boolean[] globalVisited, boolean[] visited) {
        if(visited[current]){
            return true;
        }
        if(globalVisited[current]){
            return false;
        }
        visited[current]=true;
        List<Integer> list = adj.get(current);
        for(int i=1;i<list.size();i++){
            globalVisited[current]= cyclicUtil(list.get(i), adj, globalVisited, visited);
             if(globalVisited[current]){
                 return true;
             }
        }
        visited[current]=false;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> adj=new ArrayList<List<Integer>>();
        adj.add(Arrays.asList(0,1));
        adj.add(Arrays.asList(1,7,5,2,3));
        adj.add(Arrays.asList(2,3));
        adj.add(Arrays.asList(3));
        adj.add(Arrays.asList(4));
        adj.add(Arrays.asList(5,2,0));
        adj.add(Arrays.asList(6));
        adj.add(Arrays.asList(7,8));
        adj.add(Arrays.asList(8,9));
        adj.add(Arrays.asList(9,2,10));
        adj.add(Arrays.asList(10));


        boolean ans = isCyclic(11, adj);

        System.out.println(ans);
    }
}
