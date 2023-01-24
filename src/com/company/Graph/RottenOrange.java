package com.company.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOrange {
    static class Node {
        int i, j;
        boolean visited = false;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {

        int[][] grid={{0,1,2},{0,1,2},{2,1,1}};
        orangesRotting(grid);
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Node> rottenQueue = new LinkedList<>();
        int answer = 0;
        int r= grid.length;
        int c=grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Node current = new Node(i, j);
                if (grid[i][j] == 2) {
                    rottenQueue.add(current);
                }
            }
        }
        Node temp=new Node(100,100);
        rottenQueue.add(temp);
        boolean checker=true;
        while (!rottenQueue.isEmpty()) {
            Node currentNode = rottenQueue.poll();
            if(currentNode==temp){
                if(rottenQueue.size()==0) break;
                rottenQueue.add(temp);
                checker=true;
                continue;
            }
            
            int i = currentNode.i;
            int j = currentNode.j;
            if (grid[i][j]==3) {
                continue;
            }
            grid[i][j]=3;
            if (j > 0 && grid[i][j - 1] == 1) {
                grid[i][j-1]=2;
                rottenQueue.add(new Node(i, j-1));
                if(checker){
                    answer++;
                    checker=false;
                }
            }
            if (j < c-1 && grid[i][j + 1] == 1) {
                grid[i][j+1]=2;
                rottenQueue.add(new Node(i, j+1));
                if(checker){
                    answer++;
                    checker=false;
                }
            }
            if (i > 0 && grid[i - 1][j] == 1) {
                grid[i-1][j]=2;
                rottenQueue.add(new Node(i-1, j));
                if(checker){
                    answer++;
                    checker=false;
                }
            }
            if (i < r-1 && grid[i + 1][j] == 1) {
                grid[i+1][j]=2;
                rottenQueue.add(new Node(i+1, j));
                if(checker){
                    answer++;
                    checker=false;
                }
            }
        }

        boolean x=checkClone(grid,r,c);
        if(!x){
            return -1;
        }
        return answer;

    }
    static boolean checkClone(int clone[][],int r,int c){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(clone[i][j]==1){
                    return false;
                }

            }
        }
        return true;
    }
}
