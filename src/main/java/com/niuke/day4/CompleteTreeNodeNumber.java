package com.niuke.day4;

public class CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head);
    }

    
    public static int process(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head.left) + process(head.right) + 1;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        System.out.println(nodeNum(head));
    }
}
