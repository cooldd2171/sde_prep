package com.company.DynamicProgramming;

public class StockPart1 {

    /* 
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    * 
    * */
    public static void main(String[] args) {
        
    }

    public static int maxProfit(int[] prices) {

        int answer=0;
        int min=prices[0];

        for(int i=1;i<prices.length;i++){
            answer=Math.max(prices[i]-min,answer);
            if(prices[i]<min){
                min=prices[i];
            }
        }

        return answer;
    }
}
