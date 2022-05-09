package com.company.Misc;

/*
 * To find the median of two sorted arrays
 * Naive approach would be just to merge the array and then simply find the median
 * But trick is to leverage the binary search here on the shorter list
 *
 * */

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

    }

    static double medianOfArrays(int n, int m, int a[], int b[]) {
        //Always making sure that the length of a is smaller than b
        double answer = 0;
        if (m < n) {
            return medianOfArrays(m, n, b, a);
        }
        int maxLeftA = 0;
        int minRightA = 0;
        int minRightB = 0;
        int maxLeftB = 0;

        int lo = 0;
        int hi = n;
        while (lo <= hi) {
            int partitionX = (lo + hi) / 2;
            int partitionY = ((n + m + 1) / 2) - partitionX;
            maxLeftA = partitionX==0?Integer.MIN_VALUE:a[partitionX - 1];
            minRightA = partitionX==0?Integer.MAX_VALUE:a[partitionX];
            maxLeftB = partitionY==0?Integer.MIN_VALUE:b[partitionY-1];
            minRightB = partitionY==0?Integer.MAX_VALUE:b[partitionY];
            //below part is main realization of the logic in creating the binary search which involves comparison of 
            //partition extreme values
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((n + m) % 2 == 0) {
                    answer=(double) (Math.max(maxLeftA,maxLeftB)+Math.min(minRightA,minRightB))/2;
                } else
                    answer=Math.max(maxLeftA,maxLeftB);
                break;
            }
            else if(maxLeftA>minRightB){
                hi=partitionX-1;
            }else {
                lo=partitionX+1;
            }
            
        }


        return answer;
    }

}
