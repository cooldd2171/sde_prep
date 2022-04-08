package com.company.Tree;

public class Isomorphic {

    class Node {
        int data;
        Node left, right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    boolean isIsomorphic(Node root1, Node root2) {
        // code here.
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1.data != root2.data) {
            return false;
        }

        if (isIsomorphic(root1.left, root2.left) &&
                isIsomorphic(root1.right, root2.right)) {
            return true;
        }
        if (isIsomorphic(root1.left, root2.right) &&
                isIsomorphic(root1.right, root2.left)) {
            return true;
        }

        return false;

    }
}

