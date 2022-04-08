package com.company.DynamicProgramming;

import java.util.*;

public class WordBreak {
    public static void main(String[] args){
        wordBreak("aaaaaaa",Arrays.asList( "aaaa","aa"));
    }

    static Map<String,String> map=new HashMap<>();
    static boolean exists=false;
    public static int wordBreak(String A, List<String> B )
    {
        map=new HashMap<>();
        B.forEach(each -> map.put(each, each));
        exists=false;
        find("",A);
        return exists ?1:0;
    }
    
    static void find(String current,String rest){
        if(current.equals("")&&map.containsKey(rest)){
            exists=true;
            return;
        }
        for(int i=0;i<rest.length();i++){
            current=current+rest.charAt(i);
            if(map.containsKey(current)){
                find(String.valueOf(rest.charAt(i)),rest.substring(i+1));
                find("",rest.substring(i+1));
            }
        }
    }
}
