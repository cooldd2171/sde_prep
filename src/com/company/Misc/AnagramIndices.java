package com.company.Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AnagramIndices {

    /*Input: s = "cbakbcbac", p = "abc"
    Output: [0, 6]

sizeOfS=N
sizeOfP=M

N*M
O(26)
    s=cba p=abc
    
    0,1,6
    
    26 characters
    
    Map<String,Integer> map={(c->2),(b->1),(a->1)}
    
    sizeOfMap=sizeOfP
    
    cba -> abc
    cbakcbac
    
    cba
    {(c->1),(b->1),(a->1)}
    
    bak
    {(k->1),(b->1),(c->1)}
    
    O(26*N)
    */
    
    
    public List<Integer> anagrams(String S, String P){
       
        List<Integer> indices=new ArrayList<>();
        Map<Character,Integer> frequencyMap=new HashMap<>();
        
        for(int index=0;index<P.length();index++){
            frequencyMap.put(P.charAt(index),frequencyMap.getOrDefault(P.charAt(index),0)+1);
        }
        Map<Character,Integer> windowMap=new HashMap<>();
        
        //prefilling
        for(int index=0;index<P.length();index++){
            windowMap.put(S.charAt(index),windowMap.getOrDefault(S.charAt(index),0)+1);
        }
               
        int startIndex=0;
        int endIndex=P.length();
        
        while(endIndex<S.length()){
            windowMap.put(S.charAt(startIndex),windowMap.get(S.charAt(startIndex))-1);
            windowMap.put(S.charAt(startIndex),windowMap.get(S.charAt(startIndex))+1);
            if(validateAnagram(windowMap,frequencyMap)){
                indices.add(startIndex);
            }
            endIndex++;
            startIndex++;
        }
        
        return indices;
        
    }

    private boolean validateAnagram(Map<Character, Integer> windowMap, Map<Character, Integer> comparisonMap) {
        for(Map.Entry<Character, Integer> entry: windowMap.entrySet()){
            if(!comparisonMap.containsKey(entry.getKey())||comparisonMap.get(entry.getKey())!=entry.getValue()){
                return false;
            }
        }
        return true;
    }


}
