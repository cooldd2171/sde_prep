package com.company.Misc;

import java.util.PriorityQueue;

public class minimumCostOfRopes {
    
    public static void main(String args[]){
        
    }

    long minCost(long arr[], int n)
    {
        long answer=0;
        PriorityQueue<Long> priorityQueue=new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            priorityQueue.add(arr[i]);
        }
        
        while (priorityQueue.size()>1){
            long x1=priorityQueue.poll();
            long x2=priorityQueue.poll();
            answer+=x1+x2;
            priorityQueue.add(x1+x2);
        }
        return answer;
    }
}
