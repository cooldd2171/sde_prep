package com.company.Tree;

import java.util.Arrays;
import java.util.List;

public class WordBreakTrie {
    
    public static void main(String[] args){
        List<String> words= Arrays.asList("ab","bcd","b","a");
        boolean x = wordBreak("abcd", words);
        System.out.println(x);
        
    }

    public static class TrieNode{
        TrieNode[] nodes;
        Character character;
        boolean isEnd=false;

        public TrieNode(TrieNode[] nodes, Character character, boolean isEnd) {
            this.nodes = nodes;
            this.character = character;
            this.isEnd = isEnd;
        }
    }
    
    static void insert(TrieNode root,String word){
        for(int i=0;i<word.length();i++){
            TrieNode[] connections = root.nodes;
            int index=word.charAt(i)-'a';
            if(connections[index]==null){
                connections[index]=new TrieNode(new TrieNode[26],word.charAt(i),false);
            }
            root=connections[index];
        }
        root.isEnd=true;
    }
    
    public static boolean wordBreak(String s, List<String> wordDict) {
        TrieNode trieNode=new TrieNode(new TrieNode[26],'/',true);
        for(String each: wordDict){
            insert(trieNode,each);
        }
        if(s.equals("")){
            return true;
        }
        for(int index=1;index<=s.length();index++){
            if(isValid(s.substring(0,index),trieNode) && wordBreak(s.substring(index),wordDict)){
                return true;
            }

        }
        return false;
    } 
    
    public static boolean isValid(String s,TrieNode temp){
        for(int index=0;index<s.length();index++){
            int position=s.charAt(index)-'a';
            if(temp.nodes[position]==null){
                return false;
            }
            temp=temp.nodes[position];
        }
        return temp != null && temp.isEnd;
    }
    
}
