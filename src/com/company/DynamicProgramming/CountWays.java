package com.company.DynamicProgramming;

import java.util.Arrays;
import java.util.Map;

public class CountWays {

    /*There are n stairs, a person standing at the bottom wants to reach the top.
    The person can climb either 1 stair or 2 stairs at a time.
    Count the number of ways, the person can reach the top (order does matter).
    */
    static int dp[];
    
    public static void main(String[] args){
        int x = countWays(4);
        System.out.println(x);
        
    }

    static int countWays(int n)
    {
        dp=new int[10000];
        Arrays.fill(dp,-1);
        return countWaysUtil(n);

    }
    static int countWaysUtil(int n)
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
