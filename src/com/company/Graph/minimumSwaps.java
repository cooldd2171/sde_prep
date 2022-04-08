package com.company.Graph;

import java.util.*;
import java.util.stream.Collectors;

public class minimumSwaps {
    
    static boolean[] visited;
    static List<Integer> elements;

    public static void main(String[] args) {

        int nums[]={2,4,5,1,3};
        int answer = minSwaps(nums);
        System.out.println(answer);
    }

    public static class Node implements Comparable<Node>{

        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }
    }
    
    public static int minSwaps(int nums[]) {
        int answer = 0;
        
        List<Node> priorityQueue=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            priorityQueue.add(new Node(nums[i],i));
        }

        Collections.sort(priorityQueue);
        List<Integer> list = new ArrayList<>();
        for (Node node : priorityQueue) {
            Integer index = node.getIndex();
            list.add(index);
        }
        visited=new boolean[nums.length];
        
        for(int i=0;i<list.size();i++){
            elements=new ArrayList<>();
            dfs(list,i);
            if(elements.size()!=0){
                answer+= elements.size()-1;
            }
        }
        
        return answer;
    }

    private static void dfs(List<Integer> list,int index) {
        if(visited[index]){
            if(elements.size()==0){
                return ;
            }
            return;
        }
        visited[index]=true;
        Integer value = list.get(index);
        elements.add(value);
        dfs(list,value);
    }
}
