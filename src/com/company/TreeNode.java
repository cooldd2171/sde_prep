package com.company;

public class TreeNode {
    /*
    Tree class
    * */
    public int data;
    public TreeNode left,right,random=null;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public TreeNode(int data) {
        this.data = data;
    }
}
