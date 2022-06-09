package com.company.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumEarning {
    
    /*
    this could be improved by using binary search following the longest increasing subsequence
    link: https://leetcode.com/problems/maximum-earnings-from-taxi/
    * */
    public static void main(String[] args){
        /*List<Long> pickup=Arrays.asList((long)0,(long)11,(long)19);
        List<Long> drop=Arrays.asList((long)17,(long)20,(long)21);
        List<Long> tip=Arrays.asList((long)9,(long)6,(long)0);
        long answer = taxiDriver(pickup, drop, tip, 0);
        System.out.println(answer);*/
        int[][] arr={{2,5,4},{1,5,1}};
        maxTaxiEarnings(5,arr);
        
    }

    public static long taxiDriver(List<Long> pickup, List<Long> drop, List<Long> tip, int index) {
        
        long sum=0;
        long temp=drop.get(index)-pickup.get(index)+tip.get(index);
        for(int i=index+1;i<pickup.size();i++){
            sum=Math.max(temp,sum);
            if(drop.get(i-1)<pickup.get(i)){
                sum+=taxiDriver(pickup,drop,tip,index);
            }
        }
        return sum;
        
    }

    static long dp[][];
    static public long maxTaxiEarnings(int n, int[][] rides) {
        dp=new long[rides.length][rides.length];
        for(long[] each: dp){
            Arrays.fill(each,-1);
        }
        Arrays.sort(rides, (x1,x2) -> Integer.compare(x1[0], x2[0]));
        result=0;
        long x = util(n, rides, -1, 0);
        return x;
    }
    static long  result=0;
    static long util(int n,int [][] rides, int prev,int index){
        if(index==rides.length){
            return 0;
        }
        if(dp[prev+1][index]!=-1){
            return dp[prev+1][index];
        }
        long answer=0,answer2=0;
        answer=util(n,rides,prev,index+1);
        if(prev==-1||rides[prev][1]<=rides[index][0]){
            answer2=rides[index][1]-rides[index][0]+rides[index][2]+util(n,rides,index,index+1);
        }
        answer=Math.max(answer,answer2);
        result=Math.max(result,answer);
        return dp[prev+1][index]=answer;
    }
    
}
