package com.company.Tree;

public class MirrorSymmetricTree {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    public static boolean isSymmetric(Node root)
    {
        return isMirror(root.left,root.right);
    }
    
    public static boolean isMirror(Node n1,Node n2){
        if( (n1==null&&n2!=null) || (n2==null&&n1!=null)){
            return false;
        }
        if(n1==null&&n2==null){
            return true;
        }
        if(n1.data!=n2.data){
            return false;
        }
        
        return isMirror(n1.left,n2.right) && isMirror(n1.right,n2.left);
    }
}
