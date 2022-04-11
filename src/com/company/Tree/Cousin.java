package com.company.Tree;

import com.company.TreeNode;

public class Cousin {
    
    public static void main(String[] args){
        
    }
    static int parentNode;
    static int level;
    
    public boolean isCousins(TreeNode root, int a, int b) {

        parentNode=-1;
        level=-1;
        compute(root,root,a,0);
        int parentA=parentNode;
        int levelA=level;
        parentNode=-1;
        level=-1;
        compute(root,root,b,0);
        if(levelA==level&&parentA!=parentNode){
            return true;
        }
        return false;
    }
    
    public void compute(TreeNode parent,TreeNode node,int a,int height){
        if(node==null){
            return;
        }
        if(node.data==a){
            parentNode=parent.data;
            level=height;
            return;
        }
        compute(node,node.left,a,height+1);
        compute(node,node.right,a,height+1);
    }
    
    
}
