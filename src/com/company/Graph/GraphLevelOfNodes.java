package com.company.Graph;

import java.util.*;

public class GraphLevelOfNodes {
    
    public static void main(String[] args){
        
    }

    public int levelOfX(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[V];
        queue.add(0);
        queue.add(-1);
        int level=0;
        while (queue.size()>0){
            Integer value = queue.poll();
            if(value==-1){
                level++;
                queue.add(-1);
                continue;
            }
            if(value==X){
               break;
            }
            ArrayList<Integer> connections = adj.get(value);
            for (Integer each: connections){
                if(!visited[each]){
                    visited[each]=true;
                    queue.add(each);
                }
            }
        }
        return level;
    }
}
