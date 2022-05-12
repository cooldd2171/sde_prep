package com.company.DynamicProgramming;

import java.util.Arrays;

public class JobMinDifficulty {

    /*
    * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/submissions/
    * */
    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        minDifficulty(arr, 2);
    }

    static int[][] dp;

    public static int minDifficulty(int[] jobDifficulty, int d) {
        dp = new int[1000][1000];
        if (jobDifficulty.length < d) {
            return -1;
        }
        for (int[] each : dp) {
            Arrays.fill(each, -1);
        }
        int x = minDifficultyUtil(jobDifficulty, d, 0, jobDifficulty.length);
        return x;
    }

    public static int minDifficultyUtil(int[] jobDifficulty, int d, int start, int end) {
        int result = 10000;
        if ((d > 0 && start >= end) || d == 0) {
            return 10000;
        }
        if (d == 1) {
            return getMaxInRange(jobDifficulty, start, jobDifficulty.length - 1);
        }
        if (dp[d][start] != -1) {
            return dp[d][start];
        }
        int max = 0;
        for (int i = start; i < end; i++) {
            max = Math.max(jobDifficulty[i], max);
            int answer = max + minDifficultyUtil(jobDifficulty, d - 1, i + 1, end);
            result = Math.min(answer, result);
        }
        return dp[d][start] = result;
    }

    static int getMaxInRange(int[] jobDifficulty, int start, int end) {
        int max = 0;
        for (int index = start; index <= end; index++) {
            max = Math.max(jobDifficulty[index], max);
        }
        return max;
    }
}
