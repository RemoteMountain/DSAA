package com.leetcode;

public class LC1265_ReversePrintList {

    private static class Node {
        private Node next;
        private int value;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void reversePrint(Node head) {
        if (head == null) {
            return;
        }
        reversePrint(head.next);
        System.out.print(head.value + " ");
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reversePrint(node1);

    }
}
