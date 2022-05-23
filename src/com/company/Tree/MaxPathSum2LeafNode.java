package com.company.Tree;

import com.company.TreeNode;

public class MaxPathSum2LeafNode {

    public static void main(String[] args) {
        
    }

    static long maximum=Integer.MIN_VALUE;

    int maxPathSum(TreeNode node)
    {
        maximum=Integer.MIN_VALUE;
        connect(node);
        return (int)maximum;
    }

    public static int connect( TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        if (node.left == null && node.right == null) {
            return node.data;
        }
        long l = connect(node.left);
        long r = connect( node.right);
        maximum = Math.max(maximum, node.data + l + r);
        node.data = node.data + (int)Math.max(l, r);
        return node.data;
    }
}
