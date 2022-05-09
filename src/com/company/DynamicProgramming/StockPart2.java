package com.company.DynamicProgramming;

import java.util.Arrays;

public class StockPart2 {
/*
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
* 
* You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.
* 
* 
* P.S->You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 
Find and return the maximum profit you can achieve.
 
 
class Solution {
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            dp[i][1]= -1;
            dp[i][0] = -1;
        }
        int ans =solve(prices,prices.length,1,0);
        for(int i=0;i<prices.length;i++){
            System.out.println(dp[i][0]+ " "+dp[i][1]);
        }
        return ans;
    }
    int dp[][];
     public int solve(int arr[],int len,int buy,int ind){
        if(len==ind){
            return 0;
        }
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        if(buy==1){
            int bu = -arr[ind]+ solve(arr,len,0,ind+1);
            int notBuy = solve(arr,len,1,ind+1);
            dp[ind][buy] =  Math.max(bu,notBuy);
        }
        else{
            int sell = arr[ind]+ solve(arr,len,1,ind+1);
            int notSell = solve(arr,len,0,ind+1);
            dp[ind][buy]= Math.max(sell,notSell);
        }
         return dp[ind][buy];
    }
}
 
 
 
---------------------------------------------------------------
 
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 
Find the maximum profit you can achieve. You may complete at most k transactions.
 
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 
 
class Solution {
    public int maxProfit(int k, int[] prices) {
        dp = new int[prices.length][2][k+1];
        return solve(prices,k,1,0);
    }
    public int dp[][][];
    public int solve(int arr[],int k,int buyy,int index){
        if(k==0 || index == arr.length){
            return 0;
        }
        if(dp[index][buyy][k] != 0){
            return dp[index][buyy][k];
        }
        if(buyy == 1){
            int buy = -arr[index] + solve(arr,k,0,index+1);
            int not_buy = 0 + solve(arr,k,1,index+1);
            dp[index][buyy][k]= Math.max(buy,not_buy);
        }
        else{
            int sel = arr[index] + solve(arr,k-1,1,index+1);
            int not_sel = 0 + solve(arr,k,0,index+1);
            dp[index][buyy][k]= Math.max(sel,not_sel);
        }
        return dp[index][buyy][k];
    }
}
 
 
 
 
------------------------------------
 
You are given an array prices where prices[i] is the price of a given stock on the ith day.
 
Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 
After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 
 
 
class Solution {
    public int maxProfit(int[] prices) {
        dp= new int[prices.length][2][2];
        return solve(prices,1,1,0);
    }
    int dp[][][];
    public int solve(int[] arr,int buy,int cd,int index){
        if(index == arr.length){
            return 0;
        }
        if(dp[index][buy][cd]!= 0){
            return  dp[index][buy][cd];
        }
        if(buy==1){
            int b = 0;
            int acd = 0;
            if(cd == 1){
                 dp[index][buy][cd]= Math.max(-arr[index] + solve(arr,0,cd,index+1),
                            0+ solve(arr,1,cd,index+1));
            }
            else{
                 dp[index][buy][cd] = solve(arr,1,1,index+1);
            }
 
        }
 
        else{
            int s = 0;
             dp[index][buy][cd] = Math.max(arr[index]+ solve(arr,1,0,index+1),
                        0+ solve(arr,0,cd,index+1));
 
        }
        return dp[index][buy][cd];
    }
}
 
 
---------------------------------------------------------
 
You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 
Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 
 
class Solution {
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        return solve(prices,fee,1,0);
    }
    int dp[][];
    public int solve(int arr[],int fees,int buy,int idx){
        if(arr.length==idx){
            return 0;
        }
        if(dp[idx][buy]!=0){
            return dp[idx][buy]; 
        }
        if(buy==1){
            int b = Math.max(-arr[idx] + solve(arr,fees,0,idx+1),
                            0+ solve(arr,fees,1,idx+1));
            return dp[idx][buy] = b;
        }
        else{
            int s = Math.max(arr[idx]-fees+ solve(arr,fees,1,idx+1),
                            0+ solve(arr,fees,0,idx+1));
            return dp[idx][buy] = s;
        }
    }
}
* */
    
    
    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        maxProfit(arr);
    }

    static int[][] dp;
    public static int maxProfit(int[] prices) {

        dp=new int[1000][1000];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int y=fun(prices,0,0,true);
        return y;
    }
    
    static int fun(int[] prices,int currentIndex,int buyIndex,boolean buy){
        int answer=0;
        if(currentIndex>=prices.length){
            return 0;
        }
        if(dp[currentIndex][buyIndex]!=-1){
            return dp[currentIndex][buyIndex];
        }
        //buy case
        if(buy){
            dp[currentIndex][buyIndex]=answer=Math.max(fun(prices,currentIndex+1,currentIndex,false)
                    ,fun(prices,currentIndex+1,buyIndex,true));
        }
        //sell case
        else{
            int currentProfit=prices[currentIndex]-prices[buyIndex];
                answer=Math.max(currentProfit+fun(prices,currentIndex+1,currentIndex+1,true),
                        fun(prices,currentIndex+1,buyIndex,false));
            dp[currentIndex][buyIndex]=answer;
        }
        
        return answer;
    }
    
    
}
