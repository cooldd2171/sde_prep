package com.company.DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        lcs(1,1,"","");
    }

    static int dp[][];
    static int lcs(int x, int y, String s1, String s2)
    {
        dp=new int[1000][1000];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        int z=lcsUtil(0,0,"ABC","AC");
        return z;
    }
    
    static int lcsUtil(int i,int j,String s1,String s2){
        int answer=0;
        if(i==s1.length()||j==s2.length()){
            return 0;
        }
        if (dp[i][j]!=-1)
            return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j]=answer=1+lcsUtil(i+1,j+1,s1,s2);
        }
        else{
            dp[i][j]=answer+=Math.max(lcsUtil(i,j+1,s1,s2),lcsUtil(i+1,j,s1,s2));
        }
        return answer;
    }
    
    

}
