package com.leetcode.hot100;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 验证二叉搜索树
 */
public class LC98_IsValidBST {

    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode max;

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST1(root.left);
        if (!left) {
            return false;
        }
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        boolean right = isValidBST1(root.right);
        if (!right) {
            return false;
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre != null && pre.val >= root.val) {
                    return false;
                }
                pre = root;
                root = root.right;
            }
        }
        return true;
    }
}
