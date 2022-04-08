package com.company.Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Cred {
    
    public static void main(String[] args){
        
        List<Integer> input=new ArrayList<>();
        Stack<Integer> currentStack=new Stack<>();
        
        currentStack.add(input.get(0));
        
        List<Integer> output=new ArrayList<>();
        //filler
        
        int counter=0;
        for(int index=1;index<input.size();index++){
            
            while(!currentStack.isEmpty() && output.get(index)>currentStack.peek()){
                output.add(currentStack.pop());
            }
            currentStack.add(input.get(index));
        }
        
    }
    
}
