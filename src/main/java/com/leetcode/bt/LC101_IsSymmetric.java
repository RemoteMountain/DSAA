package com.leetcode.bt;

//是否对称二叉树
public class LC101_IsSymmetric {

    public class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left.val != right.val) return false;

        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }

}
