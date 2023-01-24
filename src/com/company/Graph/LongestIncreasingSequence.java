package com.company.Graph;

import java.util.Arrays;

public class LongestIncreasingSequence {

    static boolean[][] visited;
    static int row_size;
    static int col_size;
    static int[][] moves ={{1,0},{-1,0},{0,1},{0,-1}};
    static int dp[][];

    public static void main(String[] args) {
        int[][]  matrix ={{7,8,9},{9,7,6},{7,2,3}};
        longestIncreasingPath(matrix);
    }
    public static int longestIncreasingPath(int[][] matrix) {
        row_size=matrix.length;
        col_size=matrix[0].length;
        dp=new int[row_size][col_size];
        for(int[] each: dp){
            Arrays.fill(each,-1);
        }
         int ans=0;
         for(int i=0;i<row_size;i++){
             for(int j=0;j<col_size;j++){
                 visited=new boolean[row_size][col_size];
                 ans=Math.max(ans,dfs(matrix,i,j));
             }
         }
        return ans;
    }
    
    static boolean validateMove(int i, int j,int curr_i,int curr_j,int matrix[][]){
        if(i<0||i>=row_size||j<0||j>=col_size|| visited[i][j]||matrix[i][j]<=matrix[curr_i][curr_j]){
            return false;
        }
        return true;
    }
    
    public static int  dfs(int[][] matrix, int i, int j){
        int globalAns=1;
        if(visited[i][j]){
            return globalAns;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        visited[i][j]=true;
        for(int index=0;index< moves.length;index++){
            if(validateMove(i+moves[index][0],j+moves[index][1],i,j,matrix)){
                int answer=1+dfs(matrix,i+moves[index][0],j+moves[index][1]);
                globalAns=Math.max(answer,globalAns);
            }
        }
        dp[i][j]=globalAns;
        visited[i][j]=false;
        return globalAns;
    }
    
}
