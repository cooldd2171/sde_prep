package com.company.DynamicProgramming;

import java.util.Map;

public class CountWays {

    static int dp[];
    
    public static void main(String[] args){
        int x = countWays(4);
        System.out.println(x);
        
    }

    static int countWays(int n)
    {
        int[] dp=new int[10000];
        for(int i=0;i<10000;i++){
            dp[i]=-1;
        }
        return countWays1(n);

    }
    static int countWays1(int n)
    {
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=(countWays(n-1)+countWays(n-2));
        return dp[n];
    }
}
