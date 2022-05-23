package com.company.Graph;

import java.util.*;

public class MinimumCostPath {
    
    public static void main(String[] args){
        int[][] grid={{9, 4, 9, 9},
                {6 ,7 ,6 ,4},
        {8 ,3 ,3 ,7},
    {7 ,4, 9 ,10}};
        minimumCostPath(grid);
    }

    static class Node implements Comparable<Node>{
        String key;
        int distance;

        public Node(String key, int distance) {
            this.key = key;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node n){
            return this.distance-n.distance;
        }
        
        @Override
        public boolean equals(Object o){
            Node n=(Node) o;
            return n.key.equals(this.key);
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(key);
        }
        
    }
    
    public static int minimumCostPath(int[][] grid)
    {
        int rowMax=grid.length;
        int colMax=grid[0].length;

        Map<String, List<Node>> connectionMap=new HashMap<>();
        Map<String,Integer> distanceMap=new HashMap<>();
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=0;i<rowMax;i++){
            for(int j=0;j<colMax;j++){
                String key=i+"_"+j;
                if(i==0&&j==0){
                    distanceMap.put(key,grid[0][0]);
                    pq.add(new Node(key,grid[0][0]));
                }else{
                    distanceMap.put(key,100000);
                    pq.add(new Node(key,100000));
                }
                List<Node> connections=new ArrayList<>();
                if(i-1>=0){
                    connections.add(new Node((i-1)+"_"+j,grid[i-1][j]));
                }
                if(i+1<rowMax){
                    connections.add(new Node((i+1)+"_"+j,grid[i+1][j]));
                }
                if(j-1>=0){
                    connections.add(new Node(i+ "_"+(j-1),grid[i][j-1]));
                }
                if(j+1<colMax){
                    connections.add(new Node(i+"_"+(j+1),grid[i][j+1]));
                }
                connectionMap.put(key,connections);
            }
        }
        Map<String,String> visited=new HashMap<>(); 
        while (!pq.isEmpty()){
            Node top = pq.poll();
            if(visited.containsKey(top.key)){
                continue;
            }
            visited.put(top.key,"");
            List<Node> connections = connectionMap.get(top.key);
            for(Node each: connections){
                Integer existingDistance = distanceMap.get(each.key);
                Integer newDistance = top.distance + each.distance;
                Integer minDistance=Math.min(existingDistance,newDistance);
                distanceMap.put(each.key,minDistance);
                pq.remove(new Node(each.key,1));
                pq.add(new Node(each.key,minDistance));
            }
        }
        
        return distanceMap.get((rowMax-1)+"_"+(colMax-1));
    }
    
}
