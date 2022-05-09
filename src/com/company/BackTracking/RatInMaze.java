package com.company.BackTracking;

import java.util.ArrayList;

public class RatInMaze {

    public static void main(String[] args) {
        int N = 4;
        int m[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        findPath(m, N);
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        visited = new boolean[n][n];
        answer = new ArrayList<>();
        dfs(m, n, 0, 0, "");
        return answer;

    }

    static boolean[][] visited;
    static ArrayList<String> answer;

    static boolean validate(int[][] m, int n, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n || m[i][j] == 0) {
            return true;
        }
        return false;
    }

    static void dfs(int[][] m, int n, int i, int j, String path) {


        if (i == n - 1 && j == n - 1 && m[i][j] == 1) {
            answer.add(path);
            return;
        }
        if (validate(m, n, i, j) || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(m, n, i, j - 1, path + "L");
        dfs(m, n, i + 1, j, path + "D");
        dfs(m, n, i, j + 1, path + "R");
        dfs(m, n, i - 1, j, path + "U");

        visited[i][j] = false;
        return;

    }

}
