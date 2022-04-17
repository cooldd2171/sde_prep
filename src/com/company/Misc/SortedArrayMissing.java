package com.company.Misc;

public class SortedArrayMissing {


    public static void main(String[] args) {

        int[] nums={1, 2, 3, 3, 4, 5};
        missingNumber(nums,6);
    }

    static int missingNumber(int nums[], int k) {
        int missing = 0;
        int low = 0;
        int end = k ;
        int middle=(low+end)/2;
        
        while (low<=end) {
           
            if(nums[middle]==(1+middle)){
                low=middle+1;
            }else if(nums[middle]<middle+1){
                end=middle-1;
                if(middle>0&&nums[middle-1]==nums[middle]){
                    return nums[middle];
                }
            }
            middle=(low+end)/2;
            
        }
        
        return missing;
    }
}
