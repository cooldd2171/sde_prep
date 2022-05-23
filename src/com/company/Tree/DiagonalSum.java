package com.company.Tree;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalSum {

    public static void main(String[] args) {
        TreeNode l3=new TreeNode(3);
        TreeNode l1 =new TreeNode(1);
        TreeNode r3=new TreeNode(3,l3,null);
        TreeNode root=new TreeNode(4,l1,r3);diagonalSum(root);
    }

    static ArrayList<Integer> answer;

    public static ArrayList<Integer> diagonalSum(TreeNode root) {
        answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp = new TreeNode(-1);
        queue.add(temp);
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (queue.isEmpty() && treeNode == temp) {
                break;
            }
            if (treeNode == temp) {
                answer.add(sum);
                queue.add(temp);
                sum = 0;
                continue;
            }
            while (treeNode != null) {
                sum += treeNode.data;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                treeNode = treeNode.right;
            }
        }
        answer.remove(0);
        return answer;
    }

}
