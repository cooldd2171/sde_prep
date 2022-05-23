package com.company.DynamicProgramming;

public class DpMaximumSegments {
    
    /*
    * Given an integer N denoting the Length of a line segment.
    *  You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z.
    *  Here x, y, and z are integers. After performing all the cut operations, your total number of cut segments must be maximum.

        Example 1:
        
        Input:
        N = 4
        x = 2, y = 1, z = 1
        Output: 4
        Explanation:Total length is 4, and the cut
        lengths are 2, 1 and 1.  We can make
        maximum 4 segments each of length 1.
    * */
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
