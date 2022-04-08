package com.company.Tree;

import java.util.HashMap;
import java.util.Map;

public class KSumPath {
    
    static class Node{
        Node right;
        Node left;
        int data;

        public Node(int data, Node left, Node right) {
            this.right = right;
            this.left = left;
            this.data = data;
        }
    }
    
    public static void main(String[] args){
        Node ll2=new Node(2,null,null);
        Node lrl1=new Node(1,null,null);
        Node rll1=new Node(1,null,null);
        Node rlr2=new Node(2,null,null);
        Node rr6=new Node(6,null,null);
        Node lr1=new Node(1,lrl1,null);
        Node l3=new Node(3,ll2,lr1);
        Node rl4=new Node(4,rll1,rlr2);
        Node rr5=new Node(5,null,rr6);
        Node rn1=new Node(-1,rl4,rr5);
        Node root=new Node(1,l3,rn1);
        sumK(root,5);



    }

    static int sum=0;
    public static int sumK(Node root,int k)
    {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        find(root,k,0,map);
        return sum;
    }

    public static void find(Node root,int k,int currentSum,Map<Integer,Integer> map){

        if(root==null){
            return;
        }
        int cs=currentSum+root.data;
        map.put(cs,map.getOrDefault(cs,0)+1);

        if(map.containsKey(cs-k)){
            sum+=map.get(cs-k);
        }
        find(root.left,k,cs,map);
        find(root.right,k,cs,map);
        map.remove(cs);

    }
    
}
