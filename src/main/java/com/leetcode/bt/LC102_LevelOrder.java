package com.leetcode.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树层序遍历
public class LC102_LevelOrder {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            while (size>0){
                root = queue.poll();
                list.add(root.val);
                if (root.left != null){
                    queue.offer(root.left);
                }
                if (root.right != null){
                    queue.offer(root.right);
                }
                size--;
            }
            res.add(list);
        }
        return res;
    }
}
