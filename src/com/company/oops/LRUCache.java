package com.company.oops;

import java.util.HashMap;

public class LRUCache {

    /*
     * We need a hashmap to store if the element is present in the list
     * Then need to identify the location of Node
     * Change the ordering of the list like pointing head to first
     * need to maintain head and last
     * */

    public static void main(String[] args) {

        LRUCache(2);
        set(1, 1);
        set(2, 2);
        get(1);
      
        set(3, 3);
        get(2);
        set(4, 4);
        get(1);
        get(3);
        get(4);
    }

    static class Node {
        int key;
        int value;
        Node prev,next;

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    static HashMap<Integer, Node> map;
    static int capacity = 0;
    static int currentCapacity = 0;
    static Node first, last;

    static void LRUCache(int cap) {
        map = new HashMap<>(cap);
        capacity = cap;
        first = null;
        last = null;
    }

    public static int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        changeOrdering(map.get(key));
        return map.get(key).value;
    }

    private static void changeOrdering(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        first.prev=node;
        node.next = first;
        node.prev = null;
        first = node;
    }

    public static void set(int key, int value) {
        Node node = new Node(key, value, null, null);
        if (map.containsKey(key)) {
            node = map.get(key);
            changeOrdering(node);
        } else {
            if (capacity == 0) {
                map.remove(last.key);
                last = last.prev;
                last.next = null;
                node.prev = null;
                node.next = first;
                first.prev = node;
                first = node;
            } else {
                if (first == null) {
                    first = node;
                    last = node;
                } else {
                    node.prev = null;
                    node.next = first;
                    first.prev = node;
                    first = node;
                }
                capacity--;
            }
            map.put(key, node);
        }
    }
}
