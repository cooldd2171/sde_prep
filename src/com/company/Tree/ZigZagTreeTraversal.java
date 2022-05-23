package com.company.Tree;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagTreeTraversal {

    public static void main(String[] args) {
        
        TreeNode l2=new TreeNode(2);
        TreeNode r1=new TreeNode(1);
        TreeNode root=new TreeNode(3,l2,r1);
        zigZagTraversal(root);
        
    }

    static ArrayList<Integer> zigZagTraversal(TreeNode root)
    {
        ArrayList<Integer> answer=new ArrayList<>();
        Stack<TreeNode> primary=new Stack<>();
        Stack<TreeNode> secondary=new Stack<>();
        primary.push(root);
        
        while (!primary.isEmpty() || !secondary.isEmpty()){
            while (!primary.isEmpty()){
                TreeNode node = primary.pop();
                answer.add(node.data);
                if(node.left!=null){
                    secondary.add(node.left);
                }
                if(node.right!=null){
                    secondary.add(node.right);
                }
            }
            while (!secondary.isEmpty()){
                TreeNode node = secondary.pop();
                answer.add(node.data);
                if(node.right!=null){
                    primary.add(node.right);
                }
                if(node.left!=null){
                    primary.add(node.left);
                }
            }
        }
        
        return answer;
    }
    
}
