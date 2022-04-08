package com.company.DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int A[]={6, 3, 7, 4, 6, 9};
        longestSubsequence(6,A);
    }

    static int answer=0;
    static int dp[];
    static int longestSubsequence(int size, int a[])
    {
        int max=0;
        dp=new int[size];
        for(int i=0;i<size;i++){
            dp[i]=-1;
        }
        for(int i=1;i<size;i++){
            int temp=longestSubsequence1(a,size,i,a[i-1]);
            max=Math.max(max,temp);
        }
        return max;
    }

    static int longestSubsequence1(int a[],int size, int index,int prev)
    {

        if(index==size){
            return 1;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int t1=1,t2=0;
        if(a[index]>prev){
            t1=1+longestSubsequence1(a,size,index+1,a[index]);
        }
        t2=longestSubsequence1(a,size,index+1,prev);
        dp[index]=Math.max(t1,t2);
        return dp[index];

    }
}
