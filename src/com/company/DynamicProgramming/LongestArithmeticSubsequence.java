package com.company.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {

    
    /*
    Link: https://leetcode.com/problems/longest-arithmetic-subsequence/
    * Map can be replaced by 2d array as map is slower in access than array for a particular index
    * */
    
    public static void main(String[] args) {
        int arr[]={9,4,7,2,10};
        longestArithSeqLength(arr);
    }
    
    static Map<String,Integer> map;
    public static int longestArithSeqLength(int[] nums) {
        map=new HashMap<>();
        int result=0;
        for(int i=0;i<nums.length;i++){
            result=Math.max(longestArithSeqLengthUtil(nums, i, 100000),result);
        }
        return result;
    }

    public static int longestArithSeqLengthUtil(int[] nums,int index,int difference) {
        int result=1;
        if(map.containsKey(index+"_"+difference)){
            return map.get(index+"_"+difference);
        }
        for(int i=index+1;i<nums.length;i++){
            if(nums[i]-nums[index]==difference || difference==100000){
                result=Math.max(1+longestArithSeqLengthUtil(nums,i,nums[i]-nums[index]),result);
            }
        }
        map.put(index+"_"+difference,result);
        return result;
    }
    
}
