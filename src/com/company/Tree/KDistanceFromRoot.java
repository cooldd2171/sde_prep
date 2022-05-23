package com.company.Tree;

import com.company.TreeNode;

import java.util.ArrayList;

public class KDistanceFromRoot {

    public static void main(String[] args) {
        
    }
    
    ArrayList<Integer> answer;
    ArrayList<Integer> Kdistance(TreeNode root, int k)
    {
        answer=new ArrayList<>();
        KdistanceUtil(root,k,0);
        return answer;
    }

    private void KdistanceUtil(TreeNode root, int k,int level) {
        if(root==null){
            return;
        }
        if(level>k){
            return;
        }
        if(level==k) {
            answer.add(root.data);
        }
        KdistanceUtil(root.left,k,level+1);
        KdistanceUtil(root.right,k,level+1);
    }
}
