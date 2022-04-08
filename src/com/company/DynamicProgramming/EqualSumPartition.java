package com.company.DynamicProgramming;

import java.util.*;

public class EqualSumPartition {

    static int dp[];
    public static void main(String[] args){
        int a[]={75,131,977 ,305 ,220 ,957, 47 ,56, 840};
        findPartition(a,9);
    }
    
    public static boolean findPartition(int[] a, int n)
    {
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();

        while(number>0){
            String number1 = s.nextLine();
            Map<Character,Integer> map=new HashMap<>();
            for(int i=0;i<number1.length();i++){
                map.put
                        (number1.charAt(i),map.getOrDefault(number1.charAt(i),0)+1);
            }
            int answer=1;
            for(Map.Entry<Character,Integer> each: map.entrySet()){
                answer*=each.getValue();
            }
            System.out.println(answer);
            number--;
        }

        dp=new int[n];
        boolean answer = fun(a, 0, new ArrayList<>(), new ArrayList<>());
        return answer;
    }

    public static boolean fun(int[] a, int index, List<Integer> sum1, List<Integer> sum2)
    {
        if(computeSum(sum1,sum2,a.length)){
            return true;
        }
        if(index==a.length){
            return false;
        }
        
        List<Integer> s1=new ArrayList<>(sum1);
        s1.add(a[index]);
        List<Integer> s2=new ArrayList<>(sum2);
        s2.add(a[index]);
        boolean x=fun(a,index+1,s1,sum2);
        boolean y=fun(a,index+1,sum1,s2);
        if(x||y){
            return true;
        }
        return false;
    }

    private static boolean computeSum(List<Integer> sum1, List<Integer> sum2,int n) {
        if(sum1.size()==0||((sum1.size()+sum2.size())<n)){
            return false;
        }
        int s1 = 0;
        for (Integer integer : sum1) {
            int intValue = integer.intValue();
            s1 += intValue;
        }
        int s2 = 0;
        for (Integer integer : sum2) {
            int intValue = integer.intValue();
            s2 += intValue;
        }
        return s1==s2;
    }

}
