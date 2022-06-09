package com.company.Graph;

/*
* The minions are very elitist in nature. If minion x admires minion y, then y thinks too highly of himself and does not admire x back. Also, if x admires y, x also admires everyone that y admires.
All the minions are going to be present at the Villain Con. They want to make sure that they do not dress in the same color as someone who admires them. 
There are N minions and M relations between them. The relations are given in a 2D array mat. Each relation is given in xi , yi format where yi admires xi. Find the minimum number of different colours that the minions will be dressing in. 

 

Example 1:

Input: 
N = 5, M = 6
mat = {{1, 3}, 
       {2, 3}, 
       {3, 4}, 
       {1, 4}, 
       {2, 5}, 
       {3, 5}}
Output: 3
Explaination:
If we assign red colour to 1 and 2,
green colour to 3, and blue colour to 4 and 5, then
every minion will have different coloured dresses
from the one who admires them.
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VillainCoin {


    public static void main(String[] args) {
        int mat[][] = {{6, 5},
                {4, 5},
                {4, 6},
                {5, 3},
                {5, 6},
                {6, 2}};
    }

    static int count = 0;
    static Map<Integer, Integer> countMap;

    static int minColour(int N, int M, int mat[][]) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        countMap = new HashMap<>();
        count = 0;
        for (int i = 0; i < M; i++) {
            List<Integer> connections = map.getOrDefault(mat[i][0], new ArrayList<>());
            connections.add(mat[i][1]);
            map.put(mat[i][0], connections);
        }
        for (Map.Entry<Integer, List<Integer>> each : map.entrySet()) {
            dfs(each.getKey(), map, 1);
        }
        return count;
    }

    private static int dfs(Integer key, Map<Integer, List<Integer>> map, int level) {
        if (countMap.containsKey(key)) {
            return countMap.get(key);
        }
        List<Integer> connections = map.get(key);
        if (connections == null) {
            return 0;
        }
        for (Integer each : connections) {
            dfs(each, map, ++level);
        }
        count = Math.max(level, count);
        countMap.put(key, level);
        return level;
    }

}
