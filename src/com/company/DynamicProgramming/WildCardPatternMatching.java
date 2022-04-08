package com.company.DynamicProgramming;

public class WildCardPatternMatching {
    
    public static void main(String[] args){
        String pattern = "m*q*aom***a";
        String str = "miqqaomiqqaomiqqaomiqqaomiqqaomiqqaomiqqaomiqqaomiqqaomiqqaomiqqaomiqqaomiqqaomiqqaomiqqaomiqqaomiqqao";
        wildCard(pattern,str);
    }
    static int dp[][];


    static int wildCard(String pattern, String str) {
        dp=new int[1000][1000];
        for(int i=0;i<1000;i++){
            for(int j=0;j<1000;j++){
                dp[i][j]=-1;
            }
        }
        boolean x = validate(pattern, 0, str, 0);
        if(x)return 1;
        else return 0;
    }
    
    static char[] wildcards={'*','?'};
    static boolean validate(String pattern,int ptr1, String str,int ptr2){
        if(ptr1==pattern.length()-1 && ptr2==str.length()-1){
            if(pattern.charAt(ptr1)==str.charAt(ptr2) || matches(pattern.charAt(ptr1)))
            return true;
        }
        if(ptr2==str.length()-1 &&checkLast(pattern,ptr1+1)){
            return true;
        }
        if(ptr1>=pattern.length()||ptr2>=str.length())return false;
        if(dp[ptr1][ptr2]!=-1){
            return dp[ptr1][ptr2] == 1;
        }
        if(pattern.charAt(ptr1)=='*'){
            boolean x = validate(pattern, ptr1, str, ptr2 + 1);
            if(x){
                dp[ptr1][ptr2+1]=1;
                return x;
            }
            else{
                dp[ptr1][ptr2]=0;
            }
            boolean y = validate(pattern, ptr1 + 1, str, ptr2);
            if(y){
                dp[ptr1+1][ptr2]=1;
                return true;
            }
            else{
                dp[ptr1][ptr2]=0;
            }
        }
        if((pattern.charAt(ptr1)==str.charAt(ptr2) || pattern.charAt(ptr1)=='?')){
            boolean x = validate(pattern, ptr1+1, str, ptr2+1);
            if(x){
                dp[ptr1+1][ptr2+1]=1;
                return true;
            }
            else{
                dp[ptr1+1][ptr2+1]=0;
            }
        }
        return false;
    }

    private static boolean checkLast(String pattern, int ptr1) {
        if(ptr1>=pattern.length())return false;
        for(int i=ptr1;i<pattern.length();i++){
            if(pattern.charAt(i)!='*')return false;
        }
        return true;
    }

    private static boolean matches(char charAt) {
        for (char wildcard : wildcards) {
            if (charAt == wildcard) {
                return true;
            }
        }
        return false;
    }
}
