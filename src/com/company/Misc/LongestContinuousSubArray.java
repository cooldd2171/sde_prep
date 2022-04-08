package com.company.Misc;

import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousSubArray {
    
    public static void main(String[] args){
        int nums[] = {1,3,6};
        longestSubarray(nums,3);
    }

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQueue=new LinkedList<>();
        Deque<Integer> maxQueue=new LinkedList<>();

        int ptr1=0;
        int ptr2=0;
        minQueue.add(nums[ptr1]);
        maxQueue.add(nums[ptr2]);
        int answer=1;

        while(ptr2<nums.length-1){

            if(ptr1==ptr2 || maxQueue.peek()-minQueue.peek()<=limit){
                ptr2++;
                while(maxQueue.size()>0&&maxQueue.getLast()<nums[ptr2]){
                    maxQueue.removeLast();
                }
                maxQueue.add(nums[ptr2]);

                while(minQueue.size()>0&&minQueue.getLast()>nums[ptr2]){
                    minQueue.removeLast();
                }
                minQueue.add(nums[ptr2]);
                if(maxQueue.peek()-minQueue.peek()<=limit){
                    answer=Math.max(ptr2-ptr1+1,answer);
                }

            }else{
                if(maxQueue.getFirst()==nums[ptr1]){
                    maxQueue.removeFirst();
                }
                if(minQueue.getFirst()==nums[ptr1]){
                    minQueue.removeFirst();
                }
                ptr1++;
            }


        }

        return answer;

    }
}
