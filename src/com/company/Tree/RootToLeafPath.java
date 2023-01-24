package com.company.Tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node n2=new Node(2,null,null);
        Node n3=new Node(3,null,null);
       
        Node n1=new Node(1,n2,n3);
        Paths(n1);
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // Code here
        
        ArrayList<ArrayList<Integer>> paths=new ArrayList<>();
        compute(root,new ArrayList<>(),paths);
        return paths;

    }

    static ArrayList<ArrayList<Integer>>  compute(Node root,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> paths){
        if(root==null){
            return paths;
        }
        path.add(root.data);
        if(root.left==null&&root.right==null){
            paths.add(path);
            return paths;
        }
        compute(root.left,new ArrayList<>(path),paths);
        compute(root.right,new ArrayList<>(path),paths);
        return paths;
    }
}
