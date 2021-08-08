package com.niuke.advance.day5;

import java.util.ArrayList;
import java.util.List;

public class Code_04_MaxHappy {

    public static int maxHappy(int[][] matrix) {
        int[][] dp = new int[matrix.length][2];
        boolean[] visited = new boolean[matrix.length];
        int root = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == matrix[i][0]) {
                root = i;
            }
        }
        process(matrix, dp, visited, root);
        return Math.max(dp[root][0], dp[root][1]);
    }

    public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
        visited[root] = true;
        dp[root][1] = matrix[root][1];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == root && !visited[i]) {
                process(matrix, dp, visited, i);
                dp[root][1] += dp[i][0];
                dp[root][0] += Math.max(dp[i][1], dp[i][0]);
            }
        }
    }


    //递归解法
    public static class Node {
        private int huo;
        private List<Node> nexts = new ArrayList<>();

        public Node(int huo, Node next) {
            this.huo = huo;
            nexts.add(next);
        }
    }

    public static class ReturnData {
        private int laiHuo;
        private int buLaiHuo;

        public ReturnData(int laiHuo, int buLaiHuo) {
            this.laiHuo = laiHuo;
            this.buLaiHuo = buLaiHuo;
        }
    }

    public static int getMaxHuo(Node head) {
        ReturnData data = process(head);
        return Math.max(data.laiHuo, data.buLaiHuo);
    }

    public static ReturnData process(Node head) {
        int laiHuo = head.huo;
        int buLaiHuo = 0;
        for (int i = 0; i < head.nexts.size(); i++) {
            Node next = head.nexts.get(i);
            ReturnData nextData = process(next);
            laiHuo += nextData.buLaiHuo;
            buLaiHuo += Math.max(nextData.laiHuo, nextData.buLaiHuo);
        }
        return new ReturnData(laiHuo, buLaiHuo);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 8}, {1, 9}, {1, 10}};
        System.out.println(maxHappy(matrix));
    }
}
