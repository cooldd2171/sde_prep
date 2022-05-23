package com.company.Tree;

public class ExpressionTree {
    
    /*
     Input: 
              +
           /     \
          *       -
        /  \    /   \
       5    4  100  20 

Output: 100

Explanation:
((5 * 4) + (100 - 20)) = 100
    * */
    
    class Node
    {
        String data;
        Node left,right;

        Node(String data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    
    public int evalTree(Node root) {
        // Your code here.

        if(root.left==null&&root.right==null){
            return Integer.parseInt(root.data);
        }
        int left=0,right=0;
        if(root.left!=null){
            left=evalTree(root.left);
        }
        if(root.right!=null){
            right=evalTree(root.right);
        }
        int answer=0;
        if(root.data.equals("+")){
            answer=left+right;
        }
        if(root.data.equals("-")){
            answer=left-right;
        }
        if(root.data.equals("*")){
            answer=left*right;
        }
        if(root.data.equals("/")){
            answer=left/right;
        }
        return answer;
    }
}
