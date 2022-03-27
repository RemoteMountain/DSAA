package com.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 是否对称二叉树
 */
public class LC101_IsSymmetri {

    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compaore(root.left, root.right);
    }

    private boolean compaore(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {
            return false;
        } else {
            return compaore(left.left, right.right) && compaore(left.right, right.left);
        }
    }
}
