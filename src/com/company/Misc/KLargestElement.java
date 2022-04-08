package com.company.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargestElement {
    
    public static void main(String[] args){
        
    }

    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<n;i++){
            priorityQueue.add(arr[i]);
        }
        ArrayList<Integer> answer=new ArrayList<>();
        for(int i=0;i<k;i++){
            answer.add(priorityQueue.poll());
        }
        return answer;
    }
}
