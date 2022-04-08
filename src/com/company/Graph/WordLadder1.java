package com.company.Graph;

import java.lang.reflect.Array;
import java.util.*;

public class WordLadder1 {
    
    public static void main(String[] args){
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        String startWord = "der", targetWord= "dfs";
        wordLadderLength(startWord,targetWord,wordList);

    }

    public static int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        int answer=0;
        Map<String, List<String>> map=new HashMap<>();
        
        for(String each: wordList){
            for(String second: wordList){
                if(!each.equals(second)&&checkDifference(second,each)){
                    List<String> connections=new ArrayList<>();
                    connections.add(second);
                    if(map.containsKey(each)){
                        connections.addAll(map.get(each));
                    }
                    map.put(each,connections);
                }
            }
        }
        
        int required=10000;
        boolean flag=false;
        Queue<String> queue=new LinkedList<>();
        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            Map<String,Boolean> visitedMap=new HashMap<>();
            queue=new LinkedList<>();
            if(checkDifference(startWord,entry.getKey()))
            queue.add(entry.getKey());
            answer=1;
            flag=false;
            while(queue.size()>0){
                String current = queue.poll();
                if(visitedMap.containsKey(current)){
                    continue;
                }
                visitedMap.put(current,true);
                answer++;
                if(map.get(current).contains(targetWord)){
                    flag=true;
                    break;
                }
                queue.addAll(map.get(current));
            }
            if(flag){
                required=Math.min(answer,required);
            }
        }
        
        return required+1;
    }

    private static boolean checkDifference(String secondString, String firstString) {
        int count=0;
        Map<Character,Integer> secondStringCharacterToCountMap=new HashMap<>();
        for(Character each: secondString.toCharArray()){
            Integer value = secondStringCharacterToCountMap.getOrDefault(each, 0)+1;
            secondStringCharacterToCountMap.put(each,value);
        }
        Map<Character,Integer> firstStringCharacterToCountMap=new HashMap<>();
        for(Character each: firstString.toCharArray()){
            Integer value = firstStringCharacterToCountMap.getOrDefault(each, 0)+1;
            firstStringCharacterToCountMap.put(each,value);
        }
        for(Map.Entry<Character,Integer> entry: firstStringCharacterToCountMap.entrySet()){
            if(!secondStringCharacterToCountMap.containsKey(entry.getKey())){
                count++;
            }
            else if(Math.abs(entry.getValue()-secondStringCharacterToCountMap.get(entry.getKey()))>0){
                count++;
            }
            if(count>1){
                return false;
            }
        }
        
        return true;
    }

}
