package com.company.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] arr={{1,4},{0,4}};
        merge(arr);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int start=intervals[0][0];
        int end=intervals[0][1];
        List<List<Integer>> result=new ArrayList<>();
        for(int index=1;index<intervals.length;index++){
            int i=intervals[index][0];
            int j=intervals[index][1];
            if(start>=i&&start<=j || end>=i&&end<=j || start<=i &&end>=j){
                start=Math.min(i,start);
                end=Math.max(j,end);
            }else{
                result.add(Arrays.asList(start,end));
                start=i;
                end=j;
            }
        }
        result.add(Arrays.asList(start,end));
        return result.stream().map(x -> x.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}
