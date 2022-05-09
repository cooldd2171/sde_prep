package com.company.DynamicProgramming;

import java.util.Arrays;

public class JumpGameCheckIfReachAtEnd {
    public static void main(String[] args) {

    }

    static int[] dp;
    
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        if (nums[0] == 0 && nums.length == 1) return true;
        return canJump(nums, 0);
    }

    boolean canJump(int[] nums, int index) {

        if (index >= nums.length - 1) {
            return true;
        }
        if (nums[index] == 0) {
            return false;
        }
        if (dp[index] != -1) {
            return dp[index] == 1;
        }
        for (int i = 1; i <= nums[index]; i++) {
            boolean result = canJump(nums, i + index);
            if (result) {
                dp[index] = 1;
                return true;
            }
            dp[index] = 0;

        }
        return dp[index] == 1;
    }
    
}
