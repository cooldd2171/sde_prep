package com.company.Graph;

import com.company.Main;

import java.util.*;
import java.util.stream.Collectors;

public class test {
    
    static class Node implements Comparable<Node>{
        int value;
        int distance;

        public Node(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
    
    static int dijkstra(int V, List<List<List<Integer>>> adj, int S) {
        Map<Integer, Integer> distanceMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < V; i++) {
            int distance = 0;
            if (i != S) {
                distance = Integer.MAX_VALUE;
            }
            distanceMap.put(i, distance);
            priorityQueue.add(new Node(i, distance));
        }
        while (priorityQueue.size() > 1) {
            Node node = priorityQueue.poll();
            if (visited.contains(node.value)) {
                continue;
            }
            visited.add(node.value);
            List<List<Integer>> list = adj.get(node.value);
            for (int i = 0; i < list.size(); i++) {
                List<Integer> connections = list.get(i);
                List<Integer> connection = list.get(i);
                int existingDistance = distanceMap.get(connection.get(0));
                int newDistance = distanceMap.get(node.value) + connection.get(1);
                int minDistance = Math.min(existingDistance, newDistance);
                distanceMap.put(connection.get(0), minDistance);
                priorityQueue.remove(new Node(connection.get(0), 1));
                Node element = new Node(connection.get(0), minDistance);
                priorityQueue.add(element);
            }
        }
        Map<Integer, Integer> sortedMap = distanceMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        int[] answer =new int[V];
        int i=0;
        for (Map.Entry<Integer,Integer> entry: sortedMap.entrySet()){
            answer[i]=entry.getValue();
            i++;
        }
        return 1;
    }
}
