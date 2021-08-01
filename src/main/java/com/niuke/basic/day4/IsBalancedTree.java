package com.niuke.basic.day4;

public class IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        /*int height = getHeight(head, 1, res);
        System.out.println(height);
        return res[0];*/
        int height = getHeight(head);
        System.out.println(height);
        return height == -1?false:true;
    }

    public static int getHeight(Node head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }


    public static int getHeight(Node head) {
        if (head == null) {
            return 0;
        }
        int heightLeft = getHeight(head.left);
        if (heightLeft == -1) {
            return -1;
        }
        int heightRight = getHeight(head.right);
        if (heightRight == -1) {
            return -1;
        }
        if (Math.abs(heightLeft - heightRight) > 1) {
            return -1;
        }
        return Math.max(heightLeft, heightRight) + 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));

    }

}
