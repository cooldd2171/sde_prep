package com.company.Misc;

import java.util.*;

public class IPOHeap {
    
    public static void main(String[] args){
        int a[]={1,2,3};
        int b[]={0,1,1};
        findMaximizedCapital(3,0,a,b);
        
    }

     static class array implements Comparable<array>{
        int capital;
        int index;

        public array(int capital, int index) {
            this.capital = capital;
            this.index = index;
        }

        @Override
        public int compareTo(array o) {
            return this.capital-o.capital;
        }
    }
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int answer=0;
        PriorityQueue<array> pq=new PriorityQueue<>();
        for(int i=0;i<capital.length;i++){
            pq.add(new array(capital[i],i));
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
        while(k>0){
            while(!pq.isEmpty()&&pq.peek().capital<=w){
                array a1 = pq.poll();
                maxHeap.add(profits[a1.index]);
            }
            if(!maxHeap.isEmpty()){
                int max=maxHeap.poll();
                w=w +max;
                answer=Math.max(w,answer);
            }
            
            k--;
        }
        
        return answer;
    }
    
}
