package com.company.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] arr ={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] n={4,8};
        insert(arr,n);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> answer = new ArrayList<>();
        int start=newInterval[0];
        int end=newInterval[1];
        for (int curr=0; curr< intervals.length ; curr++) {
            int i = intervals[curr][0];
            int j = intervals[curr][1];
            if(end<i){
                answer.add(Arrays.asList(start,end));
                for(int in=curr;in<intervals.length;in++){
                    answer.add(Arrays.asList(intervals[in][0],intervals[in][1]));
                }
                return answer.stream().map(x -> x.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
            }
            else if(start>=i && start<=j || end>=i  && end<=j){
               start= Math.min(start,i);
               end = Math.max(end,j);
            }
            else if(start>j){
                answer.add(Arrays.asList(i,j));
            }
        }
        answer.add(Arrays.asList(start,end));

        return answer.stream().map(x -> x.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new); 
    }
}
