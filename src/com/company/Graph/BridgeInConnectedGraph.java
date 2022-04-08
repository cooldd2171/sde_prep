package com.company.Graph;

import java.util.ArrayList;

public class BridgeInConnectedGraph {

    static boolean[] visited;
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d)
    {
        adj.get(c).remove((Integer) d);
        visited=new boolean[V];
        dfs(adj,0);
        int answer=0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                answer=1;
            }
        }
        return answer;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int current) {
        
        visited[current]=true;
        ArrayList<Integer> connections = adj.get(current);
        for(Integer each: connections){
            if(!visited[each])
            dfs(adj,each);
        }
    }

}
