package com.company.Tree;

import com.company.TreeNode;

public class KthLargestBinaryTree {
    
    public static void main(String[] args) {
        TreeNode n79=new TreeNode(79,null,null);
        TreeNode n4=new TreeNode(4,null,null);
        TreeNode n72=new TreeNode(72,null,null);
        TreeNode n69=new TreeNode(69,n4,n72);
        TreeNode n80=new TreeNode(80,n79,null);
        TreeNode root=new TreeNode(78,n69,n80);

        kthLargest(root,5);
        System.out.println(answer);
        
        
    }

    public static int kthLargest(TreeNode root, int K)
    {
        count=0;
        answer=0;
        fun(root,K);
        return answer;
    }

    static int count=0;
    static int answer=0;
    static void fun(TreeNode root,int K){

        if(root==null){
            return;
        }
        fun(root.right,K);
        count++;
        if(K==count){
            answer=root.data;
            return;
        }
        fun(root.left,K);

    }
}
