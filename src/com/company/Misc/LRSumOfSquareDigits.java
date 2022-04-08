package com.company.Misc;

import java.util.*;

public class LRSumOfSquareDigits {
    
    public static void main(String[] args){
        int grid[][]={{2,8},{4,5},{5,1}};
        solve(3,16,grid);
    }
    
    static class Pair implements Comparable<Pair>{
        int sum;
        int index;
        int value;
        public Pair(int sum, int index,int value) {
            this.sum = sum;
            this.index = index;
            this.value=value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.sum-o.sum;
        }
    }
    public static int solve(int n, int t, int[][] task){
        List<Pair> pq=new ArrayList<>();
        for(int i =0;i<n;i++){
            int sum=task[i][1]+task[i][0];
            Pair p=new Pair(sum,task[i][0],task[i][1]);
            pq.add(p);
        }
        Collections.sort(pq);
        int answer=0;
        
        int currentTime=0;
        for(int i=0;i<pq.size();i++){
            t=t-pq.get(i).value-(pq.get(i).index-currentTime);
            currentTime=pq.get(i).index;
            if(t-pq.get(i).index<0){ 
                break;
            }
            answer++;
        }
        return answer;
    }
    
}
