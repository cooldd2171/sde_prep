package com.company.Tree;

public class TreeMaxSumPath {

    static int maximum=Integer.MIN_VALUE;
    public static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;
        int height;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
            nextRight = null;
        }
    }

    public static void main(String[] args) {

       /* Node p2 = new Node(2, null, null);
        Node n3 = new Node(-3, null, null);
        Node p1 = new Node(1, null, null);
        Node p3 = new Node(3, null, null);
        Node p4 = new Node(4, null, null);
        Node p10 = new Node(10, null, null);
        
        Node n8 = new Node(-8, p2, n3);
        Node p5 = new Node(5, n8, p1);
        
        Node n1 = new Node(-1, p10, null);
        Node n0 = new Node(0, p4, n1);
        Node p9 = new Node(9, null, n0);
        Node p6 = new Node(6, p3, p9);
        Node n15 = new Node(-15, p5, p6);
        int answer = connect( n15);*/

        Node p5 = new Node(5, null, null);
        Node n10 = new Node(-10, null, null);
        Node p4 = new Node(4, null, null);
        Node p4d = new Node(4, n10, p4);
        Node p3 = new Node(3, p4d, p5);
        
        connect(p3);
        System.out.println(maximum);
    }

    public static int connect( Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        
        if (node.left == null && node.right == null) {
            return node.data;
        }
        
        int l = connect(node.left);
        int r = connect( node.right);
        if(!((node.data+l+r ) >= 2147483647)){
            maximum = Math.max(maximum, node.data + l + r);
        }
        maximum = Math.max(maximum, node.data + l + r);
        node.data = node.data + Math.max(l, r);
        return node.data;
    }
}
