package com.company.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class connectNodesAtSameLevel {

    public static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
            nextRight = null;
        }
        Node(int data){
            this.data=data;
        }
    }

    public static void main(String[] args) {
//        Node n10 = new Node(10, null, null);
//        Node n14 = new Node(14, null, null);
//        Node n3 = new Node(3, n10, null);
//        Node n4 = new Node(4, null, n14);
//        Node n5 = new Node(5, null, null);
//        Node n25 = new Node(25, null, null);
//        Node n8 = new Node(8, n5, n3);
//        Node n22 = new Node(22, n4, n25);
//        Node n20 = new Node(20, n8, n22);
        Node n1 = new Node(1, null, null);
        Node n2 = new Node(2, null, null);
        Node n3 = new Node(3, n1, n2);
        connect(n3);
        System.out.println("here");
        
    }

    public static void connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node temp=new Node(-1);
        queue.add(root);
        queue.add(temp);
        while (queue.size() > 0) {
            Node front = queue.poll();
            if(front==temp&&queue.size()>0){
                queue.add(temp);
                continue;
            }
            if(queue.peek()!=temp)
            front.nextRight=queue.peek();
            else
                front.nextRight=null;
            if(front.left!=null)
            queue.add(front.left);
            if(front.right!=null)
                queue.add(front.right);
        }
        
    }

}
