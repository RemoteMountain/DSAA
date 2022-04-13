package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC146_LRUCache {

    private class Node {
        private int value;
        private Node prev;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private class NodeDoubleLinkedList {
        private Node head;
        private Node tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void moveToTail(Node node) {
            if (tail == node) {
                return;
            }
            if (head == node) {
                this.head = head.next;
                this.head.prev = null;
            } else {
                node.prev = node.next;
                node.next.prev = node.prev;
            }
            node.prev = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        public void addNode(Node node) {
            if (tail == null) {
                this.head = node;
                this.tail = node;
            } else {
                node.prev = this.tail;
                this.tail.next = node;
                this.tail = node;
            }
        }

        public Node removeHead() {
            if (this.head == null) {
                return null;
            }
            Node res = this.head;
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = res.next;
                res.next = null;
                this.head.prev = null;
            }
            return res;
        }
    }

    private Map<Integer, Node> map;
    private List<Node> list;
    private int capacity;


    public LC146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public int get(int key) {
        return 1;
    }

    public void put(int key, int value) {
    }
}
