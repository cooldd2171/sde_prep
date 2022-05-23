package com.company.DynamicProgramming;

import java.util.Arrays;

public class Knapsack01 {
    
    public static void main(String[] args){
        int values[] = {1,2,3};
        int weight[] = {4,5,6};
        knapSack(3,weight,values,3);
    }

    static int wtt;
    static int dp[][];
    static int knapSack(int W, int wt[], int val[], int n)
    {
        dp=new int[1000][1000];
        for(int[] each: dp){
            Arrays.fill(each,-1);
        }
        wtt=W;
        int x=compute(W,wt,val,0,n-1);
        if(x<0)return 0;
        return x;
    }

    private static int compute(int w, int[] wt, int[] val, int i, int n) {
        if(i>n && w==wtt){
            return -100000;
        }
        if(w<0){
            return -100000;
        }
        if(i>n||w==0){
            return 0;
        }
        if(dp[w][i]!=-1){
            return dp[w][i];
        }
        
        int t1=val[i]+compute(w-wt[i],wt,val,i+1,n);
        int t2=compute(w,wt,val,i+1,n);
        dp[w][i]=Math.max(t1,t2);
        return dp[w][i];

    }

}
