package com.company.Tree;

import java.util.HashSet;
import java.util.Set;

public class BurningTree {

    static class Node
    {
        int data;
        Node left, right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void main(String[] args){
        Node n10=new Node(10,null,null);
        Node n7=new Node(7,null,null);
        Node n8=new Node(8,null,null);
        Node n4=new Node(4,null,null);
        Node n9=new Node(9,null,n10);
        Node n6=new Node(6,null,n9);
        Node n3=new Node(3,null,n6);
        Node n5=new Node(5,n7,n8);
        Node n2=new Node(2,n4,n5);
        Node root=new Node(1,n2,n3);
        minTime(root,8);
    }

    static int k=0;
    static Node targetNode;
    static int ans;
    static Set<Integer> visited;
    public static int minTime(Node root, int target)
    {
        k=0;
        ans=0;
        targetNode=null;
        visited=new HashSet<>();
        fun(root,target);
        visited.remove(target);
        computeDistance(targetNode,0);
        return ans;
    }

    private static boolean fun(Node root, int target) {
        if(root==null){
            return false;
        }
        if(root.data==target){
            targetNode=root;
            return true;
        }
        if(fun(root.left,target)){
            k++;
            visited.add(root.left.data);
            computeDistance(root,k);
            return true;
        }
        if(fun(root.right,target)){
            k++;
            visited.add(root.right.data);
            computeDistance(root,k);
            return true;
        }
        return false;
    }

    private static void computeDistance(Node root, int k) {
        if(root==null){
            return;
        }
        ans=Math.max(ans,k);
        if(visited.contains(root.data)){
            return;
        }
        visited.add(root.data);
        computeDistance(root.left,k+1);
        computeDistance(root.right,k+1);
    }

}
