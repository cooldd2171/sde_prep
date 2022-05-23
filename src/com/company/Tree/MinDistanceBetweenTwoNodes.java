package com.company.Tree;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinDistanceBetweenTwoNodes {

    public static void main(String[] args) {
        findDist(null, 10, 14);
    }

    static int findDist(TreeNode root, int a, int b) {
        // Your code here
        TreeNode n10 = new TreeNode(10, null, null);
        TreeNode n14 = new TreeNode(14, null, null);
        TreeNode n3 = new TreeNode(3, n10, null);
        TreeNode n4 = new TreeNode(4, null, n14);
        TreeNode n5 = new TreeNode(5, null, null);
        TreeNode n25 = new TreeNode(25, null, null);
        TreeNode n8 = new TreeNode(8, n5, n3);
        TreeNode n22 = new TreeNode(22, n4, n25);
        TreeNode n20 = new TreeNode(20, n8, n22);
        List<Integer> distanceA = findLca(n20, a, new ArrayList<>());
        List<Integer> distanceB = findLca(n20, b, new ArrayList<>());
        int counter = 0;
        while (counter < distanceA.size() && counter < distanceB.size() && distanceA.get(counter).equals(distanceB.get(counter))) {
            counter++;
        }
        return distanceA.size() - 2 * counter + distanceB.size();
    }

    static List<Integer> findLca(TreeNode root, int find, List<Integer> lca) {

        if (root == null) {
            return null;
        }
        lca.add(root.data);
        if (root.data == find) {
            return lca;
        }
        if (findLca(root.left, find, lca) == null && findLca(root.right, find, lca) == null) {
            lca.remove(lca.size() - 1);
            return null;
        }
        return lca;
    }
}
