package com.company.Misc;

import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousSubArray {
    /*
    https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
    * */
    public static void main(String[] args){
        int nums[] = {1,3,6};
        longestSubarray(nums,3);
    }

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQueue=new LinkedList<>();
        Deque<Integer> maxQueue=new LinkedList<>();

        int leftPtr=0;
        int rightPtr=0;
        minQueue.add(nums[leftPtr]);
        maxQueue.add(nums[rightPtr]);
        int answer=1;

        while(rightPtr<nums.length-1){

            if(leftPtr==rightPtr || maxQueue.peek()-minQueue.peek()<=limit){
                rightPtr++;
                while(maxQueue.size()>0&&maxQueue.getLast()<nums[rightPtr]){
                    maxQueue.removeLast();
                }
                maxQueue.add(nums[rightPtr]);

                while(minQueue.size()>0&&minQueue.getLast()>nums[rightPtr]){
                    minQueue.removeLast();
                }
                minQueue.add(nums[rightPtr]);
                if(maxQueue.peek()-minQueue.peek()<=limit){
                    answer=Math.max(rightPtr-leftPtr+1,answer);
                }

            }else{
                if(maxQueue.getFirst()==nums[leftPtr]){
                    maxQueue.removeFirst();
                }
                if(minQueue.getFirst()==nums[leftPtr]){
                    minQueue.removeFirst();
                }
                leftPtr++;
            }


        }

        return answer;

    }
}
