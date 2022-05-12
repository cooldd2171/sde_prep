package com.company.DynamicProgramming;

import java.util.Arrays;

public class MinimumCutCost {

    /*
    * Link: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
    * */
    public static void main(String[] args) {

    }

    static int length = 0;
    static int[][] dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        length = n;
        dp=new int[cuts.length+1][cuts.length+1];
        for(int[] each: dp){
            Arrays.fill(each,-1);
        }
        return minCostUtil(cuts, 0, cuts.length);
    }

    private int minCostUtil(int[] cuts, int start, int end) {
        int result = Integer.MAX_VALUE;
        if (start >= end) {
            return 0;
        }
        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        for (int i = start; i < end; i++) {
            int left = start == 0 ? 0 : cuts[start-1];
            int right = end == cuts.length ? length : cuts[end];
            int segment1 = minCostUtil(cuts, start, i);
            int segment2 = minCostUtil(cuts, i + 1, end);
            int cost = right-left + segment1 + segment2;
            result = Math.min(cost, result);
        }
        return dp[start][end]=result;
    }

}
