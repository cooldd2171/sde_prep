package com.company.Tree;

public class ChildSumParent {

    class Node{
        int data;
        Node left,right;
    }
    public static int isSumProperty(Node root)
    {
        char[] chars={'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
            'o','p','q','r','s','t','u','v','w','x','y','z'
    };
        if(root==null){
            return 1;
        }
        int l=0,r=0;

        if(root.left!=null){
            l=root.left.data;
        }
        if(root.right!=null){
            r=root.right.data;
        }
        int sum=l+r;
        if(sum==0){
            return 1;
        }
        if(root.data!=sum){
            return 0;
        }
        
        if(isSumProperty(root.left)==0){
            return 0;
        }
        if(isSumProperty(root.right)==0){
            return 0;
        }
        
        return 1;
    }
}
