package com.leetcode.linkedlist;

public class LC707_MyList {

    private int size;

    private Node head;

    private class Node {
        private Node next;
        private int val;

        public Node(int data) {
            this.val = data;
        }
    }

    public LC707_MyList() {
        this.size = 0;
        this.head = new Node(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);

    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        Node pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node newNode = new Node(val);
        newNode.next = pre.next;
        pre.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        Node pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
