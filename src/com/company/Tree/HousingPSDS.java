package com.company.Tree;

//Given a binary tree (not a binary search tree) and two values say n1 and n2,
//        write a program to find the least common ancestor.

public class HousingPSDS {
    
   static class Node{
        Node left;
        Node right;
        int data;

        public Node(Node left, Node right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
        public Node(int data){
            this.data=data;
        }
        
    }
    
    public static void main(String[] args){
       
//       Node l4=new Node(null,null,4);
//       Node r5=new Node(null,null,5);
//       Node l6=new Node(null,null,6);
//       Node r7=new Node(null,null,7);
//        Node l2=new Node(l4,r5,2);
//        Node r3=new Node(l6,r7,3);
//        Node root=new Node(l2,r3,1);

        Node l1=new Node(null,null,1);
        Node l3=new Node(null,null,3);
        Node r10=new Node(null,null,10);
        Node r9=new Node(l3,r10,9);
        Node root=new Node(l1,r9,2);


        lca(root,2,1);


    }
    static int number1;
   static int number2;
   static Node answer;
    static Node temp;
    static Node lca(Node root, int n1, int n2){
        number2=n2;
        number1=n1;
        answer=new Node(-1);
       find(root);
       if(answer.data==-1){
           if(find(temp,n2)){
               answer=temp;
           }
       }
       return answer;
    }

    private static boolean find(Node root) {
        if(root==null){
            return false;
        }
        if(root.data==number1){
            temp=root;
            return true;
        }
        if(find(root.left)){
            if(root.data==number2){
                answer=root;
                return true;
            }
            if(find(root.right,number2)){
                answer=root;
            }
            return true;
        }
        if(find(root.right)){
            if(root.data==number2){
                answer=root;
                return true;
            }
            if(find(root.left,number2)){
                answer=root;
            }
            return true;
        }
        return false;
    }

    private static boolean find(Node root,int number2) {
        if(root==null){
            return false;
        }
        if(root.data==number2){
            return true;
        }
        if(find(root.left,number2)||find(root.right,number2)){
            return true;
        }
        return false;
    }
    

}
