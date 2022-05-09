package com.company.Misc;

public class MaximumProductSubArray {

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int answer = nums[0];
        int max = 1;
        int min = 1;

        for (Integer each : nums) {
            if (each == 0) {
                max = 1;
                min = 1;
                answer = Math.max(answer, 0);
                continue;
            }
            int tempMax = max;
            max = Math.max(each, Math.max(each * tempMax, each * min));
            min = Math.min(each, Math.min(each * tempMax, each * min));
            answer = Math.max(answer, max);
        }
        return answer;
    }
}
