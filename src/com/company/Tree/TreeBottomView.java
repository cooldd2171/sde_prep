package com.company.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeBottomView {
    
    static class Node{
        int data;
        Node left,right;
        int verticalDistance;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getVerticalDistance() {
            return verticalDistance;
        }

        public void setVerticalDistance(int verticalDistance) {
            this.verticalDistance = verticalDistance;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
    public static void main(String[] args){

        Node n10=new Node(10,null,null);
        Node n14=new Node(14,null,null);
        Node n3=new Node(3,n10,null);
        Node n4=new Node(4,null,n14);
        Node n5=new Node(5,null,null);
        Node n25=new Node(25,null,null);
        Node n8=new Node(8,n5,n3);
        Node n22=new Node(22,n4,n25);
        Node n20=new Node(20,n8,n22);
        
        Map<Integer, Node> map = bottomView(n20, new HashMap<>(), 0, 0);
        Map<Integer, Node> sortedMap = new TreeMap<Integer, Node>(map);
        ArrayList<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,Node> each: sortedMap.entrySet()){
            System.out.println(each.getValue().getData());
            list.add(each.getValue().getData());
        }
    }

    public static Map<Integer,Node> bottomView(Node root, Map<Integer,Node> distanceMap,int xAxis,int vertical)
    {
        if(root==null){
            return distanceMap;
        }
        if(!distanceMap.containsKey(xAxis) || distanceMap.get(xAxis).getVerticalDistance() <= vertical){
            root.setVerticalDistance(vertical);
            distanceMap.put(xAxis,root);
        }
        bottomView(root.left,distanceMap,xAxis-1,vertical+1);
        bottomView(root.right,distanceMap,xAxis+1,vertical+1);
        return distanceMap;
    }
    
    
    
}
