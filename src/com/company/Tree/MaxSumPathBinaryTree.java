package com.company.Tree;


import com.company.TreeNode;

public class MaxSumPathBinaryTree {
    
    public static void main(String[] args){
        
    }
    static int maxi=0;
    public static int fun(TreeNode node){

        if(node==null){
            return 0;
        }
        maxi=Math.max(node.data,maxi);

        int left=fun(node.left);
        int right=fun(node.right);

        int max1=node.data+left+right;
        int max2=node.data+Math.max(left,right);

        maxi=Math.max(maxi,Math.max(max1,max2));

        node.data=Math.max(0,Math.max(node.data,Math.max(node.data+left,node.data+right)));
        return node.data;
    } 
    
}
