package com.company.Tree;

public class KthSmallestElementInBST {

     class Node
 {
     int data;
     Node left, right;

           public Node(int d)
     {
         data = d;
         left = right = null;
     }
 }

    static int count=0;
    static boolean answer=false;

    public int KthSmallestElement(Node root, int K) {
        // Write your code here
        count=0;
        answer=false;
        Node t=KthSmallestElement1(root,K);

        if(answer)
            return t.data;

        return -1;


    }

    public Node KthSmallestElement1(Node root, int K) {
        // Write your code here

        if(root==null)return null;

        Node t=KthSmallestElement1(root.left,K);
        if(answer){
            return t;
        }
        count++;
        if(K==count){
            answer=true;
            return root;
        }


        return KthSmallestElement1(root.right,K);


    }
    
}
