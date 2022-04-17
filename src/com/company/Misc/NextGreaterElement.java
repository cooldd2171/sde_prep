package com.company.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    
    public static void main(String[] args){
        long[] arr={10, 3, 12, 4, 2, 9, 13, 0, 8, 11, 1, 7, 5, 6};
       nextLargerElement(arr,14);
    }

    public static long[] nextLargerElement(long[] arr, int n)
    {
        Stack<Integer> currentStack=new Stack<>();
        currentStack.add(0);
        long[] output=new long[n];
        Arrays.fill(output,-1);
        for(int index=1;index<n;index++){
            while(!currentStack.isEmpty() && arr[index]>arr[currentStack.peek()]){
               output[currentStack.pop()]=arr[index];
            }
            currentStack.add(index);
        }
        return output;
    }

}
