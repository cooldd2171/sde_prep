package com.company.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumSpanningTree {
    
    static class Node implements Comparable<Node>{
        int src;
        int destination;
        int distance;
        
        public Node(int src,int destination, int distance){
            this.src=src;
            this.distance=distance;
            this.destination=destination;
        }
        @Override
        public int compareTo(Node n){
            return this.distance-n.distance;
        }
        
        
    }
    
    public static void main(String[] args){
        
    }

    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        PriorityQueue<Node> priorityQueue= new PriorityQueue<>();
        boolean[] visited=new boolean[V];
        int minimum=Integer.MAX_VALUE;
        Node temp=new Node(0,0,minimum);
        for(int i=0;i<adj.size();i++){
            ArrayList<ArrayList<Integer>> connections=adj.get(i);
            for(ArrayList<Integer> item: connections){
                if(item.get(1)<temp.distance){
                    temp=new Node(i,item.get(0),item.get(1));
                }
            }
        }
        priorityQueue.add(temp);
        int answer=0;
        while(priorityQueue.size()>0){
            Node node = priorityQueue.poll();
            if(visited[node.destination] && visited[node.src]){
                continue;
            }
            visited[node.destination]=true;
            visited[node.src]=true;
            answer+=node.distance;
            ArrayList<ArrayList<Integer>> connectionSrc = adj.get(node.src);
            ArrayList<ArrayList<Integer>> connectionDest = adj.get(node.destination);
            
            for(ArrayList<Integer> each: connectionSrc){
                if(!visited[each.get(0)]){
                    priorityQueue.add(new Node(node.src,each.get(0),each.get(1)));
                }
            }
            for(ArrayList<Integer> each: connectionDest){
                if(!visited[each.get(0)]){
                    priorityQueue.add(new Node(node.destination,each.get(0),each.get(1)));
                }
            }
        }
        return answer;
    }
    
}
