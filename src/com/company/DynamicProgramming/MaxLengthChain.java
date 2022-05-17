package com.company.DynamicProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class MaxLengthChain {
    
    public static void main(String[] args) {

        Pair p1=new Pair(5,24);
        Pair p2=new Pair(39,60);
        Pair p3=new Pair(15,28);
        Pair p4=new Pair(27,40);
        Pair p5=new Pair(50,90);

        Pair[] arr={p1,p2,p3,p4,p5};

        maxChainLength(arr,1);

    }
    
    static class Pair{
        int x;
        int y;

        public Pair(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }
    
    static class CompareByFirst implements Comparator<Pair> {
        
        public int compare(Pair a,Pair b){
            return a.x-b.x;
        }
    }
    static int answer;
    static int maxChainLength(Pair arr[], int n)
    {
        List<Pair> list = new ArrayList<>();
        Collections.addAll(list, arr);
        list.sort(new CompareByFirst());
        answer=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++) {
            int t=fun(list, i, list.get(i).y);
            answer=Math.max(answer,t);
        }
        if(answer!=Integer.MIN_VALUE){
            return answer+1;
        }
        return 0;
    }

    private static int fun(List<Pair> list,int index,int value) {
        if(index>=list.size()){
            return 0;
        }
        int ans=0;
        if(list.get(index).x>value){
            ans=1+fun(list,index+1,list.get(index).y);
        }
        return Math.max(ans,fun(list,index+1,value));
    }

}
