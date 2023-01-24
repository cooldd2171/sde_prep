package com.company.Graph;

import java.util.*;

public class GraphNearest1 {
    
    public static void main(String[] args){
        int[][] grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}};
        nearest(grid);
    }

    public static int[][] nearest(int[][] grid)
    {
        int rowMax=grid.length;
        int colMax=grid[0].length;
        int[][] answer=new int[rowMax][colMax];
        for(int[] each: answer){
            Arrays.fill(each,0);
        }
        Queue<int[]> queue=new LinkedList<>();
        boolean[][] visited=new boolean[rowMax][colMax];
        for(int i=0;i<rowMax;i++){
            for (int j=0;j<colMax;j++){
                if(grid[i][j]==1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[] temp={-1,-1};
        queue.add(temp);
        int distance=0;
        while(queue.size()>0){
            int[] current = queue.poll();
            if(current==temp){
                if(queue.isEmpty()){
                    break;
                }
                distance++;
                queue.add(temp);
                continue;
            }
            int i=current[0];
            int j=current[1];
            if(visited[i][j]){
                continue;
            }
            if(grid[i][j]==0){
                answer[i][j]=distance;
            }
            visited[i][j]=true;
            for (int[] move : moves) {
                int next_i = i + move[0];
                int next_j = j + move[1];
                if (validateMove(next_i, next_j, rowMax, colMax)) {
                    queue.add(new int[]{next_i, next_j});
                }
            }
        }
        return answer;
    }
    
    static int[][] moves={{1,0},{0,1},{0,-1},{-1,0}};
    
   static boolean validateMove(int i,int j,int row,int col){
        if(i<0||j<0||i>=row||j>=col){
            return false;
        }
        return true;
    }

}
