package com.company.Misc;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        
    }

    long maxArea(int A[], int len){
        long answer=0;

        int l=0;
        int r=len-1;

        while(l<r){

            answer=Math.max(answer, (long) Math.min(A[l], A[r]) *(r-l));
            if(A[l]<A[r]){
                l++;
            }
            else{
                r--;
            }
        }

        return answer;

    }
}
