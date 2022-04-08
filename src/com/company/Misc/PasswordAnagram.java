package com.company.Misc;

import java.util.HashMap;
import java.util.Map;

public class PasswordAnagram {

    public static void main(String[] arfs){
        valid("zyxabc","fghcxabyzbvf");
        
    }
    static boolean valid(String p,String s)
    {
        Map<Character,Integer> pCountMap=new HashMap<>();

        for(int index=0;index<p.length();index++){
            pCountMap.put(p.charAt(index),pCountMap.getOrDefault(p.charAt(index),0)+1);
        }
        Map<Character,Integer> sCountMap=new HashMap<>();

        for(int index=0;index<p.length();index++){
            sCountMap.put(s.charAt(index),sCountMap.getOrDefault(s.charAt(index),0)+1);
        }
        if(pCountMap.equals(sCountMap)){
            return true;
        }
        int prev=0;
        int newPtr=p.length();

        while (newPtr<s.length()){
            int count=sCountMap.getOrDefault(s.charAt(prev),1);
            count--;
            if(count==0){
                sCountMap.remove(s.charAt(prev));
            }else{
                sCountMap.put(s.charAt(prev),count);
            }
            sCountMap.put(s.charAt(newPtr),sCountMap.getOrDefault(s.charAt(newPtr),0)+1);
            if(pCountMap.equals(sCountMap)){
                return true;
            }
            newPtr++;
            prev++;
        }

        return false;
    }
}
