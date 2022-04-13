package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 二叉树展开为链表
 */
public class LC114_Flatten {

    public class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> nodes = new ArrayList<>();
        preOrder(root, nodes);
        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.get(i);
            node.left = null;
            if (i != size - 1) {
                node.right = nodes.get(i + 1);
            }
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        preOrder(root.left, nodes);
        preOrder(root.right, nodes);
    }

    private void preOrderUnRecur(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            nodes.add(root);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }
}
