package com.company.Misc;

public class StringPalindrome {

    public static void main(String[] args) {
        
    }
    
    
    public String longestPalindrome(String s) {
        String result= String.valueOf(s.charAt(0));
        for(int i=0;i<s.length();i++){
            String s1=checkPalindrome(i,i,s);
            if(s1.length()>result.length()){
                result=s1;
            }
            String s2=checkPalindrome(i,i+1,s);
            if(s2.length()>result.length()){
                result=s2;
            }
        }
        return result;
    }

    private String checkPalindrome(int l,int r, String s) {
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }

}
