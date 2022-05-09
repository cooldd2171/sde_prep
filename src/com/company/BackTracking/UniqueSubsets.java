package com.company.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueSubsets {
    
    
    public static void main(String[] args) {
        int arr[]={1,2,3};
        AllSubsets(arr,3);
    }

    public static ArrayList <ArrayList<Integer>> AllSubsets(int arr[], int n)
    {
        Arrays.sort(arr);
        answer=new ArrayList<>();
        func(0,arr,new ArrayList<>());
        return answer;
    }
    static ArrayList <ArrayList<Integer>> answer;
    static void func(int index, int[] arr, ArrayList<Integer> each){
        if(index==arr.length){
            answer.add(new ArrayList<>(each));
            return;
        }
        each.add(arr[index]);
        func(index+1,arr,each);
        each.remove(each.size()-1);
        func(index+1,arr,each);
    }
    
}
