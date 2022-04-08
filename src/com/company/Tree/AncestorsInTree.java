package com.company.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AncestorsInTree {

    static class Node
    {
        int data;
        Node left, right;
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }
    static boolean found=false;
    public static void main(String[] args){
        
    }

    public static boolean Ancestors1(Node root, int target)
    {
        if(root==null){
            return false;
        }
        if(root.data==target){
            return true;
        }
        if(Ancestors1(root.left,target)||Ancestors1(root.right,target)){
            //list.add(root.data);
            return true;
        }
        return false;
    }
}
