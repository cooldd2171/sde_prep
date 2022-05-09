package com.company.Misc;

public class MinEatingBanana {

    /*
     * leetcode: 875. Koko Eating Bananas
     * link: https://leetcode.com/problems/koko-eating-bananas/
     * */

    public static void main(String[] args) {
        int arr[]={312884470};
        minEatingSpeed(arr,312884469);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        long low = 1;
        long hi = Integer.MIN_VALUE;
        for (int iterator = 0; iterator < piles.length; iterator++) {
            if (piles[iterator] > hi) {
                hi = piles[iterator];
            }
        }
        //there will be 2 cases if there is an exact match or some hours are remaining then shift left 
        // if hours are incompatible then move right 
        // action: I need to write a boolean function which will check the array
        int answer = (int)hi;
        while (low <= hi) {
            long mid = (hi + low) / 2;
            if (validate(piles, mid, h)) {
                answer = (int)Math.min(answer, mid);
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    private static boolean validate(int[] piles, long currentRate, long h) {
        long currentHour=0;
        for (Integer each : piles) {
            currentHour+=Math.ceil((double)each/currentRate);
        }
        return currentHour<=h;
    }
}
