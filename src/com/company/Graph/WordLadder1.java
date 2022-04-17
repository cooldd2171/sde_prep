package com.company.Graph;

import java.lang.reflect.Array;
import java.util.*;

public class WordLadder1 {
    
    public static void main(String[] args){
        String[] wordList = {"soon","poon","plee","same","poie","plea","plie","poin"};
        String startWord = "toon", targetWord= "plea";
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
            if(!checkDifference(startWord,entry.getKey()))
                continue;
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

    private static boolean checkDifference(String word1, String word2) {
        if(word1.equals(word2)) // if word1 equals word2, we can always return true
            return true;

        int mistakesAllowed=1;
        if(word1.length() == word2.length()) { // if word1 is as long as word 2
            for(int i = 0; i < word1.length(); i++) { // go from first to last character index the words
                if(word1.charAt(i) != word2.charAt(i)) { // if this character from word 1 does not equal the character from word 2
                    mistakesAllowed--; // reduce one mistake allowed
                    if(mistakesAllowed < 0) { // and if you have more mistakes than allowed
                        return false; // return false
                    }
                }
            }
        }

        return true;
    }

}
