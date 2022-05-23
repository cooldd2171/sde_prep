package com.company.Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxRectangleGrid {

    /*
    * https://leetcode.com/problems/maximal-rectangle/
    * */
    public static void main(String[] args) {

        int m[][] = {{1, 0, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 0, 0, 1},
                {0, 1, 0, 0}};

        maxArea(m, 6, 4);
        System.out.println("hello");
    }

    public static int maxArea(int M[][], int n, int m) {
        int answer = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] != 0)
                    M[i][j] += M[i - 1][j];
            }
            answer = Math.max(answer, compute(M, i - 1, m));
        }
        answer = Math.max(answer, compute(M, n - 1, m));
        return answer;
    }

    public static int compute(int M[][], int i, int m) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int area = 0;

        for (int j = 1; j < m; j++) {
            int index = stack.peek();
            while (!stack.isEmpty() && M[i][stack.peek()] > M[i][j]) {
                int current = stack.pop();
                int back = stack.isEmpty()?-1:stack.peek();
                area = Math.max(area, (index - back) * M[i][current]);
            }
            stack.push(j);
        }
        area = computeForFullStack(stack, area, M, i);
        return area;

    }

    private static int computeForFullStack(Stack<Integer> stack, int area, int[][] M, int i) {
        int top = stack.isEmpty() ? -1 : stack.peek();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            int back = stack.isEmpty()?-1:stack.peek();
            area = Math.max(area, (top - back) * M[i][current]);
        }
        return area;
    }
}
