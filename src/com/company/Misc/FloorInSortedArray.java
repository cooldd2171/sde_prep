package com.company.Misc;

public class FloorInSortedArray {
    
    public static void main(String[] args){
        long arr[] = {
                35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113};
        findFloor(arr,10,159);
    }

    static long findFloor(long arr[], int n, long x)
    {
        int answer=binarySearch(arr,x);
        return answer;
    }

    private static int binarySearch(long arr[],long x) {
        
        int high=arr.length-1;
        int low=0;
        int answer=-1;
        while(low<=high){
             int mid=(low+high)/2;
            if(x>=arr[mid]&&mid+1<arr.length&&x<=arr[mid+1]){
                answer=mid;
                high=mid-1;
            }
            if(arr[mid]<x){
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        if(low>=arr.length-1){
            return arr.length-1;
        }
        return answer;
    }
}
