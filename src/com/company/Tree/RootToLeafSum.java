package com.company.Tree;

public class RootToLeafSum {

    static int sum=0;
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


        boolean answer = hasPathSum(n1, 13);
        System.out.println(answer);


    }

    static boolean hasPathSum(Node root, int S) {
         S=S-root.data;
        if(root.left==null&&root.right==null && S==0){
            return true;
        }
        boolean x1=false;
        if(root.left!=null){
            x1=hasPathSum(root.left,S);
        }
        boolean x2=false;
        if(root.right!=null){
            x2=hasPathSum(root.right,S);
        }
        if(x1||x2){
            return true;
        }
        return false;
        
    }
}
