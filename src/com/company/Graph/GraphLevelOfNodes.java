package com.company.Graph;

import java.util.*;

public class GraphLevelOfNodes {
    
    public static void main(String[] args){
        
    }

    public int levelOfX(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[V];
        Map<Integer,Integer> nodeToLevelMap=new HashMap<>();
        nodeToLevelMap.put(0,0);
        visited[0]=true;
        queue.add(0);
        while (queue.size()>0){
            Integer value = queue.poll();
            Integer level = nodeToLevelMap.get(value);
            ArrayList<Integer> connections = adj.get(value);
            for (Integer each: connections){
                if(!visited[each]){
                    nodeToLevelMap.put(each,level+1);
                    visited[each]=true;
                    queue.add(each);
                }
            }
        }
        return nodeToLevelMap.get(X);
    }
}
