package com.company.DynamicProgramming;

import java.util.Arrays;

public class MinimumCoin {

    /*
    You are given an amount denoted by value. You are also given an array of coins. The array contains the
denominations of the give coins. You need to find the minimum number of coins to make the change for value using the coins
 of given denominations. Also, keep in mind that you have infinite supply of the coins.
     Example 1:
     
     Input:
     value = 5
     numberOfCoins = 3
     coins[] = {3,6,3}
     Output: Not Possible
     Explanation:We need to make the change for
     value = 5 The denominations are {3,6,3}
     It is certain that we cannot make 5 using
     any of these coins.
    * */
    
    public static void main(String[] args) {
        
    }

    int dp[][]=new int[1000][1000];
    public long minimumNumberOfCoins(int coins[],int numberOfCoins,int value)
    {
        for(int[] each: dp){
            Arrays.fill(each,-1);
        }
        int x= call(value,0,coins);
        if(x==50000) return -1;
        return x;
    }
    int call(int sum,int index,int arr[]){
        if(sum==0)return 0;
        if(sum<0) return 50000;
        if(index>=arr.length){
            return 50000;
        }
        if(dp[index][sum]!=-1){
            return dp[index][sum];
        }
        dp[index][sum]=Math.min( 1+call(sum-arr[index],index,arr),
                call(sum,index+1,arr) );

        return dp[index][sum];
    }
}
