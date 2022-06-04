package com.company.Tree;

import com.company.TreeNode;

import java.util.ArrayList;

public class SerializeDeserializeBinaryTree {

    public void serialize(TreeNode root, ArrayList<Integer> A)
    {
        if(root==null){
            A.add(-1);
            return;
        }
        A.add(root.data);
        serialize(root.left,A);
        serialize(root.right,A);
    }

    //Function to deserialize a list and construct the tree.
    public TreeNode deSerialize(ArrayList<Integer> A)
    {
        //code here
        return deSerializUtil(A);
    }
    int index=0;
    public TreeNode deSerializUtil(ArrayList<Integer> A){
        if(index>=A.size()||A.get(index)==-1){
            return null;
        }
        TreeNode root=new TreeNode(A.get(index));
        ++index;
        root.left=deSerializUtil(A);
        ++index;
        root.right=deSerializUtil(A);
        return root;
    }
}
