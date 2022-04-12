package com.company.Tree;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeToDLL {
    public static void main(String[] args) {
        
    }
    TreeNode bToDLL(TreeNode root)
    {
        inorderTraversal=new ArrayList<>();

        inorder(root);

        TreeNode head=null;
        TreeNode prev=null;

        for(Integer each: inorderTraversal){
            TreeNode currentNode=new TreeNode(each);

            if(head==null){
                currentNode.left=null;
                head=currentNode;
            }
            else{
                prev.right=currentNode;
                currentNode.left=prev;
            }
            prev=currentNode;
        }
        return head;

    }

    static List<Integer> inorderTraversal;

    void inorder(TreeNode root){

        if(root==null){
            return;
        }

        inorder(root.left);
        inorderTraversal.add(root.data);
        inorder(root.right);

    }
}
