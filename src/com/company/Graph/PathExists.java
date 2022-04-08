package com.company.Graph;

public class PathExists {
    
    public static void main(String[] args){
        int matrix[][] = { { 0, 3, 0, 1 },
                { 3, 0, 3, 3 },
                { 2, 3, 3, 3 },
                { 0, 3, 3, 3 } };
        is_Possible(matrix);
    }

    static boolean answer=false;
    public static boolean is_Possible(int[][] grid)
    {
        int src_i=0;
        int src_j=0;
        answer=false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    src_i=i;
                    src_j=j;
                }
            }
        }
        if(possible(src_i,src_j,grid,new boolean[grid.length][grid.length]))
        return true;
        return false;
    }

    private static boolean possible(int i, int j, int[][] grid,boolean[][] visited) {
        
        if(visited[i][j]){
            return false;
        }
        if(grid[i][j]==2){
            answer=true;
            return true;
        }
        if(grid[i][j]==0){
            return false;
        }
        visited[i][j]=true;
        int rowMax=grid.length;
        int colMax= grid[0].length;
        
        if(i-1>=0&&grid[i-1][j]!=0&&!visited[i-1][j]){
            if(possible(i-1,j,grid,visited)){
                return true;
            }
        }
        if(i+1<rowMax&&grid[i+1][j]!=0&&!visited[i+1][j]){
            if(possible(i+1,j,grid,visited)){
                return true;
            }
        }
        if(j-1>=0&&grid[i][j-1]!=0&&!visited[i][j-1]){
            if(possible(i,j-1,grid,visited)){
                return true;
            }
        }
        if(j+1<colMax&&grid[i][j+1]!=0&&!visited[i][j+1]){
            if(possible(i,j+1,grid,visited)){
                return true;
            }
        }
        
        return false;
        
    }

}
