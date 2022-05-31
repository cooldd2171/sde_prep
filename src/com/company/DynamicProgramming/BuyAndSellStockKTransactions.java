package com.company.DynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStockKTransactions {

    /*
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
    */
    
    
    public static void main(String[] args) {
        int[] arr={3,2,6,5,0,3};
        int x=maxProfit(2,arr);
        System.out.println(x);
        
    }
    
    static int dp[][][];
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp=new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++) Arrays.fill(dp[i][j], -1);
        }
        return maxProfitUtil(k,prices,0,1);
    }
    
    public static int maxProfitUtil(int k,int prices[],int currentIndex,int buy){
        int profit=0;
        if(k==0 || currentIndex>=prices.length){
            return profit;
        }
        if(dp[currentIndex][buy][k]!=-1){
            return dp[currentIndex][buy][k];
        }
        if(buy==1){
            profit=Math.max(profit,Math.max(maxProfitUtil(k,prices,currentIndex+1,0)-prices[currentIndex],
                    maxProfitUtil(k,prices,currentIndex+1,1)));
        }
        else{
            profit=Math.max(profit,Math.max(maxProfitUtil(k-1,prices,currentIndex+1,1)+prices[currentIndex],
                    maxProfitUtil(k,prices,currentIndex+1,0)));
        }
        return dp[currentIndex][buy][k]=profit;
    }
}
