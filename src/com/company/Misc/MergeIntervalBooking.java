package com.company.Misc;

import java.util.*;

/*
 Merge two hotel objects based on there high and low price range. Hotel objects were not in order.

  Merge HotelRoom object when highPrice + 1 = lowPrice of other object
  Ex.1  [1,2], [3,4] ==> [1,4]
  Ex.2  [1,5],[6,9] ==> [1,9]
  Ex.3 [1,5], [14, 17], [6,9], [10,13] ==> [1,17]
  Ex.3 [1,5], [14, 17], [6,9], [10,13], [4,7], [8,12] ==> [1,17], [4,12]
*/
public class MergeIntervalBooking {

    public static void main(String[] args) {
        int[][] arr={{1,5}, {14, 17}, {6,9}, {10,13}, {4,7}, {8,12}};
        compute(arr);
    }
    
    // create a map of the end interval to index,visited
    // iterate in the intervals and search for the element present and club them adding to the output
    // always validate if the current interval is not visited 
    
    
    public static List<List<Integer>> compute(int[][] intervals){
        List<List<Integer>> answer=new ArrayList<>();
        Arrays.sort(intervals,(int[] a,int[] b)->(a[0]-b[0]));
        Map<Integer,Integer> endIntervalToIndexMap=new HashMap<>();
        int index=0;
        for(int[] each: intervals){
            endIntervalToIndexMap.put(each[0],index);
            index++;
        }
        boolean[] visited = new boolean[intervals.length];
        for (index=0;index<intervals.length;index++){
            if(visited[index]){
                continue;
            }
            visited[index]=true;
            int end=intervals[index][1];
            int last=calculate(end,visited,endIntervalToIndexMap,intervals);
            answer.add(Arrays.asList(intervals[index][0],last));
        }
        
        return answer;
    }

    private static int calculate(int end, boolean[] visited,Map<Integer,Integer> endIntervalToIndexMap,int[][] intervals) {
       while (true){
           if(!endIntervalToIndexMap.containsKey(end+1) || visited[endIntervalToIndexMap.get(end+1)]){
               break;
           }
           int index=endIntervalToIndexMap.get(end+1);
           visited[index]=true;
           end = intervals[index][1];
       }
       return end;
    }

}
