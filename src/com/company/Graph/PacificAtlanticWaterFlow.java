package com.company.Graph;

import java.util.*;

public class PacificAtlanticWaterFlow {

    /*
    https://leetcode.com/problems/pacific-atlantic-water-flow/
    * */
    public static void main(String[] args) {
        
        int[][] arr={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        pacificAtlantic(arr);

    }
    
    static class Pair{
        int x;
        int y;
        
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList<>();
        int row = heights.length;
        int column = heights[0].length;

        HashSet<Pair> pacific =new HashSet<>();
        HashSet<Pair> atlantic =new HashSet<>();
        
        int[][] visited =new int[row][column];
        for(int[] each: visited){
            Arrays.fill(each,-1);
        }
        for(int j=0;j<column;j++){
            dfs(0,j,heights,visited,pacific,-1);
        }
        for(int i=0;i<row;i++){
            dfs(i,0,heights,visited,pacific,-1);
        }
        for(int[] each: visited){
            Arrays.fill(each,-1);
        }
        for(int j=0;j<column;j++){
            dfs(row-1,j,heights,visited,atlantic,-1);
        }
        for(int i=0;i<row;i++){
            dfs(i,column-1,heights,visited,atlantic,-1);
        }
        for(Pair each: pacific){
            if (atlantic.contains(each)){
                answer.add(Arrays.asList(each.x,each.y));
            }
        }
        return answer;
    }
    
    static void dfs(int i,int j,int[][] heights,int[][] visited,HashSet<Pair> set,int prev){
        if(!validateMove(i,j,heights,prev,visited)){
            return;
        }
        visited[i][j]=1;
        set.add(new Pair(i,j));
        dfs(i,j+1,heights,visited,set,heights[i][j]);
        dfs(i,j-1,heights,visited,set,heights[i][j]);
        dfs(i+1,j,heights,visited,set,heights[i][j]);
        dfs(i-1,j,heights,visited,set,heights[i][j]);
    }

    private static boolean validateMove(int i, int j, int[][] heights, int prev, int[][] visited) {
        int row = heights.length;
        int column = heights[0].length;
        
        if(i>=row||j>=column||i<0||j<0||visited[i][j]==1||heights[i][j]<prev){
            return false;
        }
        
        return true;
    }


}
