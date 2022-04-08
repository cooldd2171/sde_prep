package com.company.Graph;

public class GraphNumberOfIslands {
    
    public static void main(String[] args){
        
    }

    static boolean[][] visited;
    static int rowMax;
    static int colMax;
    public int numIslands(char[][] grid) {
         rowMax=grid.length;
         colMax=grid[0].length;
        visited=new boolean[rowMax][colMax];
        int answer=0;
        
        for(int i=0;i<rowMax;i++){
            for(int j=0;j<colMax;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                    dfs(grid,i,j);
                    answer++;
                }
            }
        }
        
        return answer;
    }

    private void dfs(char[][] grid,int i, int j) {
        if(i<0||i>=rowMax||
                j<0 ||j>=colMax||
                grid[i][j]=='0'||
                visited[i][j]){
            return;
        }
        visited[i][j]=true;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j-1);
        dfs(grid,i-1,j+1);
        dfs(grid,i+1,j-1);
        dfs(grid,i+1,j+1);
    }

}
