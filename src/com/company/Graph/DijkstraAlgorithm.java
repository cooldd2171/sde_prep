package com.company.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstraAlgorithm {
    
    public static void main(String[] args){
        List<List<List<Integer>>> adj=new ArrayList<>();
        
        List<Integer> zero1=  Arrays.asList(1,1);
        List<Integer> zero2= (List<Integer>) Arrays.asList(2,4);
        List<List<Integer>> zeros=  Arrays.asList(zero1,zero2);
        adj.add(zeros);

        List<Integer> one0= (List<Integer>) Arrays.asList(0,1);
        List<Integer> one2= (List<Integer>) Arrays.asList(2,4);
        List<Integer> one3= (List<Integer>) Arrays.asList(3,2);
        List<Integer> one4= (List<Integer>) Arrays.asList(4,7);

        List<List<Integer>> ones= (List<List<Integer>>) Arrays.asList(one0,one2,one3,one4);
        adj.add(ones);

        List<Integer> two1= (List<Integer>) Arrays.asList(1,4);
        List<Integer> two0= (List<Integer>) Arrays.asList(0,4);
        List<Integer> two4= (List<Integer>) Arrays.asList(4,5);
        List<Integer> two3= (List<Integer>) Arrays.asList(3,3);

        List<List<Integer>> twos= (List<List<Integer>>) Arrays.asList(two1,two0,two4,two3);
        adj.add(twos);

        List<Integer> three1= (List<Integer>) Arrays.asList(1,2);
        List<Integer> three2= (List<Integer>) Arrays.asList(2,3);
        List<Integer> three4= (List<Integer>) Arrays.asList(4,4);
        List<Integer> three5= (List<Integer>) Arrays.asList(5,6);

        List<List<Integer>> threes= (List<List<Integer>>) Arrays.asList(three1,three2,three4,three5);
        adj.add(threes);

        List<Integer> four1= (List<Integer>) Arrays.asList(1,7);
        List<Integer> four2= (List<Integer>) Arrays.asList(2,5);
        List<Integer> four3= (List<Integer>) Arrays.asList(3,4);
        List<Integer> four5= (List<Integer>) Arrays.asList(5,7);

        List<List<Integer>> fours= (List<List<Integer>>) Arrays.asList(four1,four2,four3,four5);
        adj.add(fours);

        List<Integer> five4= (List<Integer>) Arrays.asList(4,7);
        List<Integer> five3= (List<Integer>) Arrays.asList(5,6);

        List<List<Integer>> fives= (List<List<Integer>>) Arrays.asList(five4,five3);
        adj.add(fives);

        dijkstra(6,adj,0);
    }
    
    static class Node implements Comparable<Node>{
        int value;
        int distance;

        public Node(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance-o.distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    static int[] dijkstra(int V, List<List<List<Integer>>> adj, int S)
    {
        Map<Integer,Integer> distanceMap=new HashMap<>();
        Set<Integer> visited=new HashSet<>();
        PriorityQueue<Node> priorityQueue=new PriorityQueue<>();
        for(int i=0;i<V;i++){
            int distance=0;
            if(i!=S){
                distance=100000;
            }
            distanceMap.put(i,distance);
            priorityQueue.add(new Node(i,distance));
        }
        
        while (priorityQueue.size()>1){
            Node node = priorityQueue.poll();
            if(visited.contains(node.value)){
                continue;
            }
            visited.add(node.value);
            List<List<Integer>> list = adj.get(node.value);
            for(int i=0;i<list.size();i++){
                List<Integer> connection = list.get(i);
                int existingDistance=distanceMap.get(connection.get(0));
                int newDistance=distanceMap.get(node.value)+connection.get(1);
                int minDistance=Math.min(existingDistance,newDistance);
                distanceMap.put(connection.get(0),minDistance);
                priorityQueue.remove(new Node(connection.get(0),1));
                Node element=new Node(connection.get(0),minDistance);
                priorityQueue.add(element);
            }
        }
        Map<Integer, Integer> sortedMap = distanceMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        int[] answer =new int[V];
        int i=0;
        for(Map.Entry<Integer,Integer> entry: sortedMap.entrySet()){
            answer[i]=entry.getValue();
            i++;
        }
        return answer;
    }
}
