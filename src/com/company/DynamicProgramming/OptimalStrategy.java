package com.company.DynamicProgramming;

public class OptimalStrategy {
    
    public static void main(String[] args){
        int A[] = {8,15,3,7};
        countMaximum(A,4);
    }

    static long dp[][];
    static long countMaximum(int arr[], int n)
    {
        dp=new long[1000][1000];
        for(int i=0;i<1000;i++){
            for(int j=0;j<1000;j++){
                dp[i][j]=-1;
            }
        }
        long x = countMaximum(arr, 0, n - 1);
        return x;
        
    }


    static long countMaximum(int arr[], int i,int j)
    {
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        long choice1=arr[i]+ Math.min(countMaximum(arr,i+2,j),countMaximum(arr,i+1,j-1));
        long choice2=arr[j] + Math.min(countMaximum(arr,i+1,j-1),countMaximum(arr,i,j-2));
        
        dp[i][j]=Math.max(choice1,choice2);
        
        return dp[i][j];
    }
    
}
