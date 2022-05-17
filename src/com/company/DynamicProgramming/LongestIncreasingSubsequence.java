package com.company.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int A[]={6, 3, 7, 4, 6, 9};
        longestSubsequence(6,A);
    }

    static int answer=0;
    static int dp[][];
    static int longestSubsequence(int size, int a[])
    {
        int max=0;
        dp=new int[size][size];
        for(int[] each: dp){
            Arrays.fill(each,-1);
        }
        int temp=longestSubsequence1(a,size,0,-1);
        max=Math.max(max,temp);
        return max;
    }

    static int longestSubsequence1(int a[],int size, int index,int prev_index)
    {

        if(index==size){
            return 0;
        }
        if(prev_index!=-1&&dp[index][prev_index]!=-1){
            return dp[index][prev_index];
        }
        int t1=longestSubsequence1(a,size,index+1,prev_index);
        int t2=0;
        if(prev_index==-1 || a[index]>a[prev_index]){
            t1=1+longestSubsequence1(a,size,index+1,index);
        }
        int max=Math.max(t1,t2);
        if(prev_index!=-1)
        dp[index][prev_index]=max;
        return max;

    }
}
