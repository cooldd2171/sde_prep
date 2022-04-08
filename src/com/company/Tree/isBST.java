package com.company.Tree;

import com.company.TreeNode;

public class isBST {
    
    public static void main(String[] args) {
        
        TreeNode n2=new TreeNode(2,null,null);
        TreeNode n4=new TreeNode(4,null,null);
        TreeNode n6=new TreeNode(6,null,null);
        TreeNode n7 =new TreeNode(7,n6,null);
        TreeNode n8=new TreeNode(8,n7,null);
        TreeNode n5=new TreeNode(5,n4,n8);
        TreeNode n1=new TreeNode(1,null,n2);
        TreeNode root=new TreeNode(3,n1,n5);
        boolean x= isBST(root);
        System.out.println(x);
        
    }

    static boolean isBST(TreeNode root)
    {
       return isBST(root,0,100000);
    }

    static boolean isBST(TreeNode root, int min,int max)
    {
        if(root==null){
            return true;
        }
        
        if(root.data>max&&root.data<min){
            return false;
        }
        
        return isBST(root.left,min,root.data)&&isBST(root.right,root.data,max);
    }
}
