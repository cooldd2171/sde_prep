package com.company.Misc;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr={0,3,7,2,5,8,4,6,0,1};
        longestConsecutive(arr);
        
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int answer=0;
        for(Integer each:nums){
            map.put(each,0);
        }
        for(Integer each: nums){
            if(map.get(each)>0){
                continue;
            }
            int counter=1;
            int toFind=each+1;
            while(map.containsKey(toFind)){
                if (map.get(toFind)>0){
                    counter+=map.get(toFind);
                    break;
                }
                map.put(toFind,1);
                toFind++;
                counter++;
            }
            answer=Math.max(counter,answer);
            map.put(each,counter);
        }
        return answer;
    }
}
