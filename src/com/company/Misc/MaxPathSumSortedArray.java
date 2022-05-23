package com.company.Misc;

public class MaxPathSumSortedArray {
    
    /*
    * https://leetcode.com/problems/get-the-maximum-score/
    * */
    public static void main(String[] args){
        
    }

    int maxSum(int ar1[], int ar2[])
    {
        int answer=0;
        int ptr1=0,ptr2=0;
        
        int sum1=0,sum2=0;
        
        while(ptr1<ar1.length||ptr2<ar2.length){
            if(ptr1==ar1.length){
                for(int i=ptr2;i<ar2.length;i++){
                    sum2+=ar2[i];
                }
                break;
            }
            if(ptr2==ar2.length){
                for(int i=ptr1;i<ar1.length;i++){
                    sum1+=ar1[i];
                }
                break;
            }
            if(ar1[ptr1]==ar2[ptr2]){
                answer+=Math.max(sum1,sum2)+ar1[ptr1];
                sum1=0;
                sum2=0;
                ptr1++;
                ptr2++;
            }
            else if(ar1[ptr1]<ar2[ptr2]){
                sum1+=ar1[ptr1];
                ptr1++;
            }
            else if(ar2[ptr2]<ar1[ptr1]){
                sum2+=ar2[ptr2];
                ptr2++;
            }
        }
        
        return answer+Math.max(sum1,sum2);
    }
    
}
