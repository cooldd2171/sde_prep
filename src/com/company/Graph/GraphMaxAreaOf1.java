package com.company.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphMaxAreaOf1 {
    public static void main(String[] args){
        
    }

    static boolean[][] visited;
    static int rowSize=0;
    static int colSize=0;
    public static int findMaxArea(int[][] grid)
    {
        int answer=0;
        Queue<Integer> queue=new LinkedList<>();
        visited=new boolean[grid.length][grid[0].length];
         rowSize=grid.length;
         colSize=grid[0].length;
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                answer=Math.max(dfs(grid,i,j),answer);
            }
        }
        
        return answer;
    }
    
    static int dfs(int grid[][],int i, int j){
        
        if(i<0||i>=rowSize||
                j<0 ||j>=colSize||
                grid[i][j]==0||
                visited[i][j]){
            return 0;
        }
        visited[i][j]=true;
        
        return 1+dfs(grid,i-1,j)+dfs(grid,i+1,j)+dfs(grid,i,j-1)+dfs(grid,i,j+1)
                +dfs(grid,i-1,j-1)+dfs(grid,i-1,j+1)+dfs(grid,i+1,j-1)+dfs(grid,i+1,j+1);
    }
    
    
}
