package com.company.Graph;

import java.util.*;

public class GraphNearest1 {
    
    public static void main(String[] args){
        int[][] grid = {{0,1,1,0},{1,1,0,0},{0,0,1,1}};
        nearest(grid);
    }

    public static class Pair{
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public static int[][] nearest(int[][] grid)
    {
        int rowMax=grid.length;
        int colMax=grid[0].length;
        int[][] answer=new int[rowMax][colMax];
        Queue<Pair> queue=new LinkedList<>();
        boolean[][] visited=new boolean[rowMax][colMax];
        Map<Pair,Integer> distanceMap=new HashMap<>();
        for(int i=0;i<rowMax;i++){
            for (int j=0;j<colMax;j++){
                Pair node=new Pair(i,j);
                if(grid[i][j]==1){
                    queue.add(node);
                    distanceMap.put(node,0);
                }
            }
        }

        while(queue.size()>0){
            Pair node = queue.poll();
            int i=node.i;
            int j=node.j;
            int distance=distanceMap.get(node)+1;
            if(visited[i][j]){
                continue;
            }
            visited[i][j]=true;
            if(i-1>=0&&grid[i-1][j]==0&&!visited[i-1][j]){
                queue.add(new Pair(i-1,j));
                if(!distanceMap.containsKey(new Pair(i-1,j)))answer[i-1][j]=distance;
                distanceMap.putIfAbsent(new Pair(i-1,j),distance);
            }
            if(j-1>=0&&grid[i][j-1]==0&&!visited[i][j-1]){
                queue.add(new Pair(i,j-1));
                if(!distanceMap.containsKey(new Pair(i,j-1)))
                answer[i][j-1]=distance;
                distanceMap.putIfAbsent(new Pair(i,j-1),distance);
            }
            if(i+1<rowMax&&grid[i+1][j]==0&&!visited[i+1][j]){
                queue.add(new Pair(i+1,j));
                if(!distanceMap.containsKey(new Pair(i+1,j)))
                answer[i+1][j]=distance;
                distanceMap.putIfAbsent(new Pair(i+1,j),distance);
            }
            if(j+1<colMax&&grid[i][j+1]==0&&!visited[i][j+1]){
                queue.add(new Pair(i,j+1));
                if(!distanceMap.containsKey(new Pair(i,j+1)))
                answer[i][j+1]=distance;
                distanceMap.putIfAbsent(new Pair(i,j+1),distance);
            }
        }
        return answer;
    }

    private static int[][] fillAnswer(int rowMax, int colMax, Map<Pair, Integer> distanceMap) {
        int[][] answer=new int[rowMax][colMax];

        for(Map.Entry<Pair,Integer> entry: distanceMap.entrySet()){
            int i=entry.getKey().i;
            int j=entry.getKey().j;
            answer[i][j]=entry.getValue();
        }
        return answer;
    }

}
