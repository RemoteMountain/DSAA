package com.leetcode.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//翻转二叉树
public class LC226_InvertTree {

    public class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public TreeNode invertTreePreOderRecur(TreeNode root) {
        if (root == null) {
            return root;
        }
        swap(root);
        invertTreePreOderRecur(root.left);
        invertTreePreOderRecur(root.right);
        return root;
    }

    public TreeNode invertTreePreOderUnRecur(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            swap(cur);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return root;
    }

    public TreeNode invertTreeInOderUnRecur(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                swap(cur);
                cur = cur.right;
            }
        }
        return root;
    }

    public TreeNode invertTreeLevelOder(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.poll();
                swap(cur);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                size--;
            }
        }
        return root;
    }


    private void swap(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
