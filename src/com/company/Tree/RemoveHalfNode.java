package com.company.Tree;

import com.company.TreeNode;

public class RemoveHalfNode {
    
    
    public static void main(String[] args){
        TreeNode n2=new TreeNode(2,null,null);
        TreeNode n8=new TreeNode(8,null,null);
        TreeNode n7=new TreeNode(7,n2,null);
        TreeNode root=new TreeNode(7,n7,n8);

        RemoveHalfNodes(root);
        
    }

    public static TreeNode RemoveHalfNodes(TreeNode root)
    {
        
        fun(root,root,0);
        return root;
    }

    public static void fun(TreeNode root,TreeNode prev,int p){

        if(root==null||root.left==null&&root.right==null){
            return;
        }
        if(root.left==null){
            if(p==0){
                prev.left=root.right;
            }
            if(p==1){
                prev.right=root.right;
            }
        }

        else if(root.right==null){
            if(p==0){
                prev.left=root.left;
            }
            if(p==1){
                prev.right=root.left;
            }
        }
        else{
            prev=root;
        }

        fun(root.left,prev,0);
        fun(root.right,prev,1);
    }

    public static TreeNode RemoveHalfNodesV2(TreeNode root)
    {
        if(root==null){
            return null;
        }

        TreeNode left=RemoveHalfNodesV2(root.left);
        TreeNode right=RemoveHalfNodesV2(root.right);
        root.left=left;
        root.right=right;
        if(left==null&&right==null){
            return root;
        }
        if(root.left==null){
            return root.right;
        }
        if(root.right==null){
            return root.left;
        }
        return root;
    }
    
    
}
