package com.company.Tree;

import com.company.TreeNode;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        
    }

    static int result=0;
    
    public int longestConsecutive(TreeNode root)
    {
        result=0;
        longestConsecutiveUtil(root.left,root.data+1,1);
        longestConsecutiveUtil(root.right,root.data+1,1);
        return result;
    }

    private void longestConsecutiveUtil(TreeNode root, int expected, int seq) {
        if(root==null){
            return;
        }
        seq=root.data==expected?++seq:1;
        result=Math.max(result,seq);
        longestConsecutiveUtil(root.left,root.data+1,seq);
        longestConsecutiveUtil(root.right,root.data+1,seq);
    }
}
