package com.company.Tree;

import com.company.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreeFromPostOrderAndInOrder {
    
    public static void main(String[] args) {
        int in[] = {4, 8, 2, 5, 1 ,6, 3, 7};
        int post[] = {8, 4, 5, 2, 6, 7, 3, 1};
        buildTree(in,post,8);
    }

    static TreeNode buildTree(int in[], int post[], int n) {
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        for (int i1 = 0; i1 < post.length; i1++) {
            Integer each = i1;
            valueToIndexMap.put(post[each], each);
        }
        TreeNode node = func(0, n - 1, in,valueToIndexMap);
        return node;
        
    }
    
    static TreeNode func(int i,int j,int in[],Map<Integer,Integer> valueToIndexMap){
        if(i>j){
          return null;  
        }
        int k=findPos(i,j,in,valueToIndexMap);
        TreeNode node=new TreeNode(in[k]);
        node.left=func(i,k-1,in,valueToIndexMap);
        node.right=func(k+1,j,in,valueToIndexMap);
        return node;
    }

    static private int findPos(int i, int j, int[] in, Map<Integer,Integer> valueToIndexMap) {
        if(i==j){
            return j;
        }
        int answer=0;
        int position=0;
        for(int index=i;index<=j;index++){
            if(valueToIndexMap.get(in[index])>answer){
                position=index;
                answer=valueToIndexMap.get(in[index]);
            }
        }
        return position;
    }
}
