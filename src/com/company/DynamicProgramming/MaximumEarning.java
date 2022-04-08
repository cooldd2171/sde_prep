package com.company.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumEarning {
    
    public static void main(String[] args){
        List<Long> pickup=Arrays.asList((long)0,(long)11,(long)19);
        List<Long> drop=Arrays.asList((long)17,(long)20,(long)21);
        List<Long> tip=Arrays.asList((long)9,(long)6,(long)0);
        long answer = taxiDriver(pickup, drop, tip, 0);
        System.out.println(answer);
        
    }

    public static long taxiDriver(List<Long> pickup, List<Long> drop, List<Long> tip, int index) {
        
        long sum=0;
        long temp=drop.get(index)-pickup.get(index)+tip.get(index);
        for(int i=index+1;i<pickup.size();i++){
            sum=Math.max(temp,sum);
            if(drop.get(i-1)<pickup.get(i)){
                sum+=taxiDriver(pickup,drop,tip,index);
            }
        }
        return sum;
        
    }
    
}
