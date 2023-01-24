package com.company.Tree;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodesAtGivenDistanceTree {

    static class Node {
        int data;
        Node left, right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        Node l10 = new Node(10, null, null);
        Node l4 = new Node(4, null, null);
        Node r14 = new Node(14, null, null);
        Node r22 = new Node(22, null, null);
        Node r12 = new Node(12, l10, r14);
        Node l8 = new Node(8, l4, r12);
        Node root = new Node(20, l8, r22);
        KDistanceNodes(root, 8, 2);

    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        targetLevel = 0;
        answer = new ArrayList<>();
        targetNode = null;
        traverse(root, target, k, 0);
        computeDistance(targetNode, k);
        Collections.sort(answer);
        return new ArrayList<>(answer);
    }

    static int targetLevel = 0;
    static List<Integer> answer = new ArrayList<>();
    static Node targetNode;

    private static boolean traverse(Node node, int target, int k, int level) {
        if (node == null) {
            return false;
        }
        if (node.data == target) {
            targetLevel = level;
            targetNode = node;
            return true;
        }
        if (traverse(node.left, target, k, level + 1)) {
            if (k - targetLevel + level == 0) {
                answer.add(node.data);
            } else
                computeDistance(node.right, k - targetLevel + level - 1);
            return true;
        }
        if (traverse(node.right, target, k, level + 1)) {
            if (k - targetLevel + level == 0) {
                answer.add(node.data);
            } else
                computeDistance(node.left, k - targetLevel + level - 1);
            return true;
        }

        return false;
    }

    private static void computeDistance(Node node, int distance) {
        if (node == null || distance < 0) {
            return;
        }
        if (distance == 0) {
            answer.add(node.data);
            return;
        }
        computeDistance(node.left, distance - 1);
        computeDistance(node.right, distance - 1);
    }

}
