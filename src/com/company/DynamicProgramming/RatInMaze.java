package com.company.DynamicProgramming;

import java.util.ArrayList;

public class RatInMaze {
    
    public static void main(String[] args){
        int N = 4;
        int m[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};
        findPath(m,N);
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        visited=new boolean[n][n];
        answer=new ArrayList<>();
        dfs(m,n,0,0,"");
        return answer;

    }

    static boolean[][] visited;
    static ArrayList<String> answer;

    static void dfs(int[][] m,int n, int i,int j,String path){

        if(i<0 || j<0 || i>=n ||j>=n || visited[i][j]){
            return;
        }
        if(i==n-1&&j==n-1){
            answer.add(path);
            return;
        }

        visited[i][j]=true;
        if(i-1>=0 && m[i-1][j]==1 && !visited[i-1][j]){
            path=path+"U";
            dfs(m,n,i-1,j,path);
        }

        if(j-1>=0 && m[i][j-1]==1 && !visited[i][j-1] ){
            path=path+"L";
            dfs(m,n,i,j-1,path);
        }

        if(i+1<n && m[i+1][j]==1 && !visited[i+1][j]){
            path=path+"D";
            dfs(m,n,i+1,j,path);
        }

        if(j+1<n && m[i][j+1]==1 && !visited[i][j+1]){
            path=path+"R";
            dfs(m,n,i,j+1,path);
        }

        visited[i][j]=false;
        path=path.substring(0,path.length()-1);
        return;

    }
    
}
