package com.company.Graph;

import java.util.*;

public class KHighestRanked {

    public static void main(String[] args) {
        int arr[][] = {{1,1,1}, {0,0,1}, {2,3,4}};
        int price[] = {2, 3};
        int start[] = {0, 0};
        int k = 3;
        highestRankedKItems(arr, price, start, k);
    }

    static boolean[][] visited;
    static int[][] coord = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {

        List<List<Integer>> answer = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
        int low = pricing[0];
        int high = pricing[1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited = new boolean[row][col];
        while (!queue.isEmpty() ) {
            int[] current = queue.poll();
           
            if (visited[current[0]][current[1]]) {
                continue;
            }
            int value = grid[current[0]][current[1]];
            visited[current[0]][current[1]] = true;
            if (value > 0) {
                for (int index = 0; index < 4; index++) {
                    if (valid(index, current[0], current[1], row - 1, col - 1)) {
                        queue.add(new int[]{current[0] + coord[index][0], current[1] + coord[index][1]});
                    }
                }
                if (value >= low && value <= high)
                    answer.add(Arrays.asList(current[0], current[1]));
            }
        }
        answer.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int distanceA = Math.abs(start[0] - o1.get(0)) + Math.abs(start[1] - o1.get(1));
                int distanceB = Math.abs(start[0] - o2.get(0)) + Math.abs(start[1] - o2.get(1));
                
                if (distanceA > distanceB) {
                    return 1;
                }
                int priceA = grid[o1.get(0)][o1.get(1)];
                int priceB = grid[o2.get(0)][o2.get(1)];
                if (priceA > priceB) {
                    return 1;
                }
                if(o1.get(1)>o2.get(1))
                return 1;
                
                return -1;
            }
        });
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<k&&i<answer.size();i++){
            result.add(answer.get(i));
        }
        return result;
    }

    private static boolean valid(int index, int i, int j, int row, int col) {
        if (coord[index][0] + i > row || coord[index][0] + i < 0 ||
                coord[index][1] + j > col || coord[index][1] + j < 0 || visited[coord[index][0] + i][coord[index][1] + j]) {
            return false;
        }

        return true;
    }
}
