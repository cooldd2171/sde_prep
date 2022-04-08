package com.company.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCA {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void main(String[] args){
        Node n2=new Node(2,null,null);
        Node n7=new Node(7,null,null);
        Node n6=new Node(6,null,null);

        Node n5=new Node(5,n7,null);
        Node n4=new Node(4,null,n5);
        Node n3=new Node(3,n4,n6);
        Node n1=new Node(1,n2,n3);
        Node x = lca(n1, 4, 7);
        System.out.println(x.data);
        
    }
    static List<Node> list1;
    static Node lca(Node root, int n1,int n2)
    {
        list1=new ArrayList<>();
        traverse(root,n1);
        List<Node> list=new ArrayList<>(list1);
        list.add(0,new Node(n1,null,null));
        list1=new ArrayList<>();
        traverse(root,n2);
        List<Node> list2=new ArrayList<>(list1);
        list2.add(0,new Node(n2,null,null));
        Map<Integer, Node> map = new HashMap<>();
        for (Node e : list2) {
            if (map.put(e.data, e) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }
        Node n=root;
        for(Node each: list){
            if(map.containsKey(each.data)){
                n=each; 
                break;
            }
        }
return n;
    }
    
    static boolean traverse(Node node,int search){
        if(node==null){
            return false;
        }
        if(search==node.data){
            return true;
        }
        if(traverse(node.left,search)||traverse(node.right,search)){
            list1.add(node);
            return true;
        }
        return false;
    }
    
}
