package com.company.Misc;

public class CircularSubarrayMaxSum {

    public static void main(String[] args) {
        int arr[]={-18};
        circularSubarraySum(arr,1);
    }

    static int circularSubarraySum(int a[], int n) {

        // Your code here
        return Integer.max(kadane(a,n), reverseKadane(a,n));
    }

    static int kadane(int[] a,int n){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(Integer each: a){
            max=Math.max(each,max);
            sum+=each;
            if(sum<0){
                sum=0;
            }else
                max=Math.max(sum,max);
        }
        return max;
    }

    static int reverseKadane(int a[],int n){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int iterator=0;iterator<n;iterator++){
            sum+=a[iterator];
        }
        for(int iterator=0;iterator<n;iterator++){
            a[iterator]=-a[iterator];
        }
        int reverseSum=kadane(a,n);
        return sum+reverseSum==0?sum:sum+reverseSum;
    }

}
