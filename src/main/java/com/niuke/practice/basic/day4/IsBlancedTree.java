package com.niuke.practice.basic.day4;

/**
 * 判断是否是平衡二叉树
 */
public class IsBlancedTree {

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        System.out.println(getHeight(head, 1, res));
        return res[0];
    }

    private static int getHeight(Node head, int level, boolean[] res) {
        return 0;
    }

    public static int getHeight(Node head) {
        return 0;
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
