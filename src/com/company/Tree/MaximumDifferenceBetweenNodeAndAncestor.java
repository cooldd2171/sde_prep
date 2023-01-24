package com.company.Tree;

import com.company.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {
    
    public static void main(String[] args) {
        
    }

    int maxDiff(TreeNode root)
    {
        answer=Integer.MIN_VALUE;
        compute(root,Integer.MIN_VALUE);
        return answer;
    }
    int answer;
    void compute(TreeNode node,int max){
        if(node==null){
            return;
        }
        answer=Math.max(max-node.data,answer);
        if(max<node.data)
            max=node.data;
        compute(node.left,max);
        compute(node.right,max);
        
    }
}
