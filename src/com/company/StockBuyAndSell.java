package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockBuyAndSell {

    public static void main(String[] args) {

        int A[] = {310, 40, 535, 695};
        List<List<Integer>> days = stockBuySell(A, 0, A[0]);
        System.out.println("here");
    }

    static List<List<Integer>> stockBuySell(int A[], int index, int value) {

        if (index == A.length) {
            return new ArrayList<>();
        }
        
        if (A[index] > value) {
            return Arrays.asList(Arrays.asList(value,A[index]));
        }
        List<List<Integer>> a1=new ArrayList<>();
        List<List<Integer>> a2=new ArrayList<>();
        a2.addAll(stockBuySell(A, index + 1, value));
        if (index < A.length - 1) {
            a1.addAll(stockBuySell(A, index + 1, A[index + 1]));
        }
        int sum1=computeSum(a1);
        int sum2=computeSum(a2);

        if(sum1>sum2)return a1;
        return a2;
    }

    private static int computeSum(List<List<Integer>> list) {
        int sum=0;
        for(List<Integer> each: list){
            sum+=each.get(1)-each.get(0);
        }
        return sum;
    }

}
