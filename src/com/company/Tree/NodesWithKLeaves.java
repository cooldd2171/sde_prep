package com.company.Tree;

import com.company.TreeNode;

import java.util.ArrayList;

public class NodesWithKLeaves {

    public static void main(String[] args) {
        TreeNode n10 = new TreeNode(10, null, null);
        TreeNode n14 = new TreeNode(14, null, null);
        TreeNode n3 = new TreeNode(3, n10, null);
        TreeNode n4 = new TreeNode(4, null, n14);
        TreeNode n5 = new TreeNode(5, null, null);
        TreeNode n25 = new TreeNode(25, null, null);
        TreeNode n8 = new TreeNode(8, n5, n3);
        TreeNode n22 = new TreeNode(22, n4, n25);
        TreeNode n20 = new TreeNode(20, n8, n22);
        btWithKleaves(n20,1);
    }
    
    public static ArrayList<Integer> btWithKleaves(TreeNode root, int k)
    {
        list=new ArrayList<>();
        traverse(root,k);
        return list;
    }
    
    static ArrayList<Integer> list=new ArrayList<>();
    
    static int traverse(TreeNode node, int k){
        int answer=0;
        if(node.left==null&&node.right==null){
           return 1; 
        }
        if(node.left!=null)
        answer+=traverse(node.left,k);
        if(node.right!=null)
        answer+=traverse(node.right,k);
        if(k==answer)list.add(node.data);
        return answer;
    }
    
    
}
