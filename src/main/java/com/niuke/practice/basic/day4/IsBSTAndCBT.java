package com.niuke.practice.basic.day4;

public class IsBSTAndCBT {

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBSTWithInOrderUnRecur(Node head) {
        return true;
    }

    public static boolean isCBT(Node head) {
        return true;
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(Node head, int height, String to, int len) {

    }

    public static String getSpace(int len) {
        return "";
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        //System.out.println(isBST(head));
        System.out.println(isBSTWithInOrderUnRecur(head));
        //System.out.println(isCBT(head));

    }

}
