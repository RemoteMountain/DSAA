package com.niuke.practice.basic.day4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsBSTAndCBT {

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int data) {
            this.value = data;
        }
    }

    private static boolean isBST(Node head) {
        return false;
    }

    public static boolean isBSTWithInOrderUnRecur(Node head) {
        if (head == null) {
            return true;
        }
        Stack<Node> stack = new Stack();
        int pre = Integer.MIN_VALUE;
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.value < pre) {
                    return false;
                }
                pre = head.value;
                head = head.right;
            }
        }

        return true;
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Node l = null;
        Node r = null;
        boolean leaf = false;
        Queue<Node> queue = new LinkedList();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (leaf && (l != null || r != null) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(head.left);
            }
            if (r != null) {
                queue.offer(head.right);
            } else {
                leaf = true;
            }
        }
        return true;
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", 17);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", 17);
    }

    public static String getSpace(int len) {
        String space = " ";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < len; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isBSTWithInOrderUnRecur(head));
        System.out.println(isCBT(head));

    }



}
