package com.company.Misc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class rearrangeCharacters {
    
    public static void main(String[] args){
        String answer = rearrangeCharacters("geeksforgeeks");
        System.out.println(answer);
    }

    public static class Info{
        String string;
        Integer frequency;

        public Info(String string, Integer frequency) {
            this.string = string;
            this.frequency = frequency;
        }
        
    }
    
    
    static String rearrangeCharacters(String str)
    {
        String answer="";
        PriorityQueue<Info> priorityQueue=new PriorityQueue<Info>((x,y)->y.frequency-x.frequency);
                Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            priorityQueue.add(new Info(entry.getKey().toString(),entry.getValue()));
        }
        while(priorityQueue.size()>1){
            Info object1 = priorityQueue.poll();
            object1.frequency=object1.frequency-1;
            answer+=object1.string;
            Info object2 = priorityQueue.poll();
            object2.frequency= object2.frequency-1;
            answer+=object2.string;
            if(object1.frequency>0){
                priorityQueue.add(object1);
            }
            if(object2.frequency>0){
                priorityQueue.add(object2);
            }
        }
        if(priorityQueue.size()==1&&priorityQueue.peek().frequency==1){
            answer+=priorityQueue.peek().string;
        }
       return answer;
    }
}
