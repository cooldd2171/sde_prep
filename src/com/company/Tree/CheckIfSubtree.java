package com.company.Tree;

import com.company.TreeNode;

public class CheckIfSubtree {

    public static boolean isSubtree(TreeNode T, TreeNode S) {
        if(T==null&&S==null){
            return true;
        }
        if(T==null){
            return false;
        }
        if(S==null){
            return false;
        }
        if(isSubtreeUtil(T,S)){
            return true;
        }
        return isSubtree(T.left,S)||isSubtree(T.right,S);
    }

    public static boolean isSubtreeUtil(TreeNode T,TreeNode S){
        if(T==null&&S==null){
            return true;
        }
        if(T==null){
            return false;
        }
        if(S==null){
            return false;
        }
        if(T.data!=S.data){
            return false;
        }
        return isSubtreeUtil(T.left,S.left)&&isSubtreeUtil(T.right,S.right);
    }
}
