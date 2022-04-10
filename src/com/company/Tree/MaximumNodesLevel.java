package com.company.Tree;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumNodesLevel {
    
    public static void main(String[] args) {
        TreeNode r9= new TreeNode(9,null,null);
        TreeNode l9= new TreeNode(9,null,null);
        TreeNode r6= new TreeNode(6,null,null);
        TreeNode l8= new TreeNode(8,null,r9);
        TreeNode r7= new TreeNode(7,l9,r6);
        TreeNode root=new TreeNode(7,l8,r7);
        maxNodeLevel(root);




    }

    public static int maxNodeLevel(TreeNode root)
    {
        int level=0;
        int answer=0;
        TreeNode temp=new TreeNode(-1);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        queue.add(temp);
        int count=0;
        int currentCount=0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            currentCount++;
            if(node==temp&&!queue.isEmpty()){
                if(currentCount>count){
                    count=currentCount;
                    answer=level;
                }
                queue.add(temp);
                currentCount=0;
                level++;
            }
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }
        if(currentCount>count){
            answer=level;
        }
        return answer;
    }
}
