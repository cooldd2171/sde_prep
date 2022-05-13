package com.company.Misc;

import java.util.Objects;
import java.util.PriorityQueue;

public class FindMaxValueEquation {

    public static void main(String[] args) {
        int arr[][]={{1,3},{2,0},{5,10},{6,-10}};
        findMaxValueOfEquation(arr,1);
    }

    /*
    * https://leetcode.com/problems/max-value-of-equation/submissions/
    * The same code runs perfectly in C++ but having problem in java
    *  maybe because of the class i have created
    * */
    static class Info implements Comparable<Info>{
        int sum;
        int x;

        public Info(int sum, int x) {
            this.sum = sum;
            this.x = x;
        }
        @Override
        public int compareTo(Info node){
            return node.sum-this.sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return x == info.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x);
        }
    }
    
    public static int findMaxValueOfEquation(int[][] points, int k) {
        int answer=Integer.MIN_VALUE;
        PriorityQueue<Info> pq=new PriorityQueue<>();
        
        int begin=1;
        int length=points.length;
        for(int index=0;index<length;index++){
            while (begin<length && points[begin][0]-points[index][0]<=k){
                pq.add(new Info(points[begin][0]+points[begin][1],points[begin][0]));
                begin++;
            }
            pq.remove(new Info(1,points[index][0]));
            if(!pq.isEmpty()){
                answer=Math.max(answer,points[index][1]-points[index][0]+pq.peek().sum);
            }
        }
        
        return answer;
    }
    
    
    
    
}
