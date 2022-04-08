package com.company.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class LeafAtSameLevel {

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
    
    static Map<Integer,Integer> map=new HashMap<>();
    
    public static void main(String[] args) {
        Node l2 = new Node(2, null, null);
        Node r3 = new Node(3, null, null);
        Node root = new Node(1, l2, r3);
        check(root);
    }

    static boolean check(Node root)
    {
        map=new HashMap<>();
        traverseLeaf(root,0);
        return map.size() <= 1;
    }

    static private void traverseLeaf(Node root,int level) {
        
        if(root.left==null&&root.right==null){
            map.put(level,0);
            return;
        }
        level++;
        if(root.left!=null){
            traverseLeaf(root.left,level);
        }
        if(root.right!=null){
            traverseLeaf(root.right,level);
        }
        
    }
}
