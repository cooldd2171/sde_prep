package com.company.Tree;

import com.company.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CloneTree {

    public static void main(String[] args) {
        TreeNode n10=new TreeNode(10,null,null);
        TreeNode n14=new TreeNode(14,null,null);
        TreeNode n3=new TreeNode(3,n10,null);
        TreeNode n4=new TreeNode(4,null,n14);
        TreeNode n5=new TreeNode(5,null,null);
        TreeNode n25=new TreeNode(25,null,null);
        TreeNode n8=new TreeNode(8,n5,n3);
        TreeNode n22=new TreeNode(22,n4,n25);
        TreeNode n20=new TreeNode(20,n8,n22);
        TreeNode answer = cloneTree(n20);
        System.out.println(1);
    }
static Map<TreeNode,TreeNode> valueNodeMap;
    public static TreeNode cloneTree(TreeNode tree){
        valueNodeMap=new HashMap<>();
        valueNodeMap.put(null,null);
        TreeNode node = cloneTreeUtil(tree);
        arrangePointers(tree,node);
        return node;
    }

    private static void arrangePointers(TreeNode tree, TreeNode node) {
        if(tree==null){
            return;
        }
        TreeNode left = tree.left;
        TreeNode right = tree.right;
        TreeNode random=tree.random;
        node.left=valueNodeMap.get(left);
        node.right=valueNodeMap.get(right);
        node.random=valueNodeMap.get(random);
        arrangePointers(tree.left,node.left);
        arrangePointers(tree.right,node.right);
    }

    public static TreeNode cloneTreeUtil(TreeNode tree){
        if(tree==null){
            return null;
        }
        TreeNode node=new TreeNode(-1);
        node.data=tree.data;
        valueNodeMap.put(tree,node);

        cloneTreeUtil(tree.left);
        cloneTreeUtil(tree.right);

        return node;
    }
    
    
}
