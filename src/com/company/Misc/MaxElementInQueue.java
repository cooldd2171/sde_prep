package com.company.Misc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxElementInQueue {

    public static void main(String[] args) {
        
        int[] arr={1,3,1,2,0,5};
        maxSlidingWindow(arr,3);
        
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> queue=new LinkedList<>();
        int[] output=new int[nums.length-k+1];
        for(int index=0;index<k;index++){
            while(!queue.isEmpty()&&queue.getLast()<nums[index]){
                queue.removeLast();
            }
            queue.add(nums[index]);
        }
        //3,-1
        int ptr2=k;
        for(int index=0;index<nums.length-k;index++){
            output[index]=queue.peek();
            if(nums[index]==queue.peek())
            queue.removeFirst();
            
            while(!queue.isEmpty()&&queue.getLast()<nums[ptr2]){
                queue.removeLast();
            }
            queue.add(nums[ptr2]);
            ptr2++;
        }
        output[nums.length-k]=queue.removeFirst();
        return output;
    }
}
