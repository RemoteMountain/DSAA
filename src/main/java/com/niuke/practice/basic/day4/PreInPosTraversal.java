package com.niuke.practice.basic.day4;

/**
 * 实现二叉树的先序、中序、后序遍历，
 * 包括递归方式和非递归方式
 */
public class PreInPosTraversal {

    public static class Node {
        private Node left;
        private Node right;
        private int value;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * 递归前序打印
     *
     * @param head 二叉树头节点
     */
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);

    }

    /**
     * 递归中序打印
     *
     * @param head 二叉树头节点
     */
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 递归后序打印
     *
     * @param head 二叉树头节点
     */
    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");

    }

    /**
     * 非递归前序打印
     *
     * @param head 二叉树头节点
     */
    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        System.out.println();
    }

    /**
     * 非递归中序打印
     *
     * @param head 二叉树头节点
     */
    public static void inOrderUnRecur(Node head) {
        System.out.print("in-order: ");
        System.out.println();
    }

    /**
     * 非递归后序打印
     * 前序：中左右
     * 后续：左右中
     * 前序+栈 实现 后序
     *
     * @param head 二叉树头节点
     */
    public static void posOrderUnRecur1(Node head) {
        System.out.print("pos-order: ");
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
    }
}
