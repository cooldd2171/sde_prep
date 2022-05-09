package com.company.Misc;

public class ReverseSentence {
    
    public static StringBuilder reverseString(StringBuilder input,int begin,int end){
        while(begin<=end){
            char temp=input.charAt(begin);
            input.setCharAt(begin,input.charAt(end));
            input.setCharAt(end,temp);
            begin++;
            end--;
        }
        return input;
    }
    
    public static void main(String[] args) {
        String input1="hello   good sunny   daytime";
        StringBuilder input=new StringBuilder(input1);
        int start=0;
        int end=input.length()-1;

        reverseString(input,start,end);
        start=0;
        while(start<input.length()){
            while(input.charAt(start)==' '){
                start++;
            }
            int begin=start;
            while(start<input.length() && input.charAt(start)!=' '){
                start++;
            }
            end=start-1;
            reverseString(input,begin,end);
        }
        System.out.println(input);
    }
}
