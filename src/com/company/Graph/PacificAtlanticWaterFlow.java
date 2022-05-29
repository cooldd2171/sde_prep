package com.company.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PacificAtlanticWaterFlow {

    /*
    https://leetcode.com/problems/pacific-atlantic-water-flow/
    * */
    public static void main(String[] args) {
        
        int[][] arr={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        pacificAtlantic(arr);

    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList<>();
        int row = heights.length;
        int column = heights[0].length;
        int[][] top = buildDistanceTop(heights, row, column);
        int[][] bottom = buildDistanceBottom(heights, row, column);
        int[][] right = buildDistanceRight(heights, row, column);
        int[][] left = buildDistanceLeft(heights, row, column);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if ((top[i][j] ==1 || left[i][j] ==1) &&
                        (bottom[i][j] ==1|| right[i][j] ==1)) {
                    answer.add(Arrays.asList(i, j));
                }
            }
        }

        return answer;
    }

    private static int[][] buildDistanceLeft(int[][] heights, int row, int column) {
        int[][] arr = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(j==0){
                    arr[i][j]=1;
                }else{
                    arr[i][j] = arr[i][j-1]==0?0:heights[i][j]>heights[i][j - 1]?1:0;
                }
            }
        }
        return arr;
    }

    private static int[][] buildDistanceRight(int[][] heights, int row, int column) {
        int[][] arr = new int[row][column];
        for (int i = row-1; i >=0; i--) {
            for (int j = column-1; j >=0 ; j--) {
                if(j==column-1){
                    arr[i][j]=1;
                }else{
                    arr[i][j] = Math.max(heights[i][j], arr[i][j + 1]);
                }
            }
        }
        return arr;
    }

    private static int[][] buildDistanceBottom(int[][] heights, int row, int column) {
        int[][] arr = new int[row][column];
        for (int j = 0; j < column; j++) {
            for (int i = row-1; i >= 0; i--) {
                if(i==row-1){
                    arr[i][j]=heights[i][j];
                }else{
                    arr[i][j] = Math.max(heights[i][j], arr[i+1][j]);
                }
            }
        }
        return arr;
    }

    private static int[][] buildDistanceTop(int[][] heights, int row, int column) {
        int[][] arr = new int[row][column];
        for (int j = 0; j < column; j++) {
            for (int i = 0; i < row; i++) {
                if(i==0){
                    arr[i][j]=heights[i][j];
                }else{
                    arr[i][j] = Math.max(heights[i][j], arr[i-1][j]);
                }
            }
        }
        return arr;

    }
}
