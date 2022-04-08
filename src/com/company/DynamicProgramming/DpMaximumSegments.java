package com.company.DynamicProgramming;

public class DpMaximumSegments {
    
    static int dp[];
    public static void main(String[] args){
        maximizeCuts(11,2,3,5);
    }

    public static int maximizeCuts(int n, int x, int y, int z)
    {
        dp=new int[10000];
        for(int i=0;i<10000;i++){
            dp[i]=-1;
        }
        int answer= maximizeCuts1(n,x,y,z);
        return answer;
        
    }

    public static int maximizeCuts1(int n, int x, int y, int z)
    {
        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MIN_VALUE;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int t1=1+maximizeCuts1(n-x,x,y,z);
        int t2=1+maximizeCuts1(n-y,x,y,z);
        int t3=1+maximizeCuts1(n-z,x,y,z);

        dp[n]=Math.max(t1,Math.max(t2,t3));
        return dp[n];
    }
}
