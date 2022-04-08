package com.company.DynamicProgramming;

public class MinimumNumberOfJumps {
    
    public static void main(String[] args){
        int arr[]={2, 3, 1 ,1, 2,4, 2, 0, 1, 1};
        minimumJumps(arr,10);
    }
    static int dp[];

    public static int minimumJumps(int arr[], int n)
    {
        dp=new int[100000];
        for(int i=0;i<100000;i++){
            dp[i]=-1;
        }
        int x = fun(arr, 0);
        return x;
    }
    
    static int fun(int arr[],int ptr1){
        
        if(ptr1>=arr.length-1){
            return 0;
        }
        if(arr[ptr1]==0){
            return 100000;
        }
        if(dp[ptr1]!=-1)return dp[ptr1]-1;
        int answer=Integer.MAX_VALUE;
        boolean flag=false;
        
        for(int i=ptr1+1;i<=arr[ptr1]+ptr1;i++){
            int t1=1+fun(arr,i);
            if(answer>t1){
                answer=t1;
            }
            flag=true;
            dp[i]=answer;
        }
        if(!flag){
            return 0;
        }
        return answer;
        
    }
    
}
