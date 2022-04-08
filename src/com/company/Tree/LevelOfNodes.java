package com.company.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LevelOfNodes {

    Map<Integer,Integer> map;

    public static void main(String[] args){
        
    }

    public int levelOfX(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        map=new HashMap<>();
        dfs(adj,0,9,0);
        int answer=-1;
        for(int i=0;i<adj.get(0).size();i++){
            answer=Math.max(answer,map.get(adj.get(0).get(i)));
        }
        if(answer>100000){
            return -1;
        }
        return answer;
    }
    
    public int dfs(ArrayList<ArrayList<Integer>> adj,int index,int X,int preSum){
        if(adj.get(index).size()==0){
            return 100000;
        }
        if(map.containsKey(index)){
            return map.get(index);
        }
        if (index==X){
            return 1;
        }
        map.put(index,preSum+1);
        ArrayList<Integer> list = adj.get(index);
        for(Integer each: list){
           /* if(map.containsKey())
                int variable = 1 + dfs(adj, each, X);
                map.put(each,variable);*/
        }
        return -1;
    }
}
