package com.niuke.practice.basic.day5;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 */
public class UnionFind {

    public static class UnionFindSet {
        public HashMap<Node, Node> fatherMap; // k-节点，v-节点的父节点
        public HashMap<Node, Integer> sizeMap; // k-节点，v-节点所在集合节点个数

        public UnionFindSet() {
            fatherMap = new HashMap();
            sizeMap = new HashMap();
        }

        public void makeSet(List<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node: nodes) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        public Node findHead(Node node) {
            return null;
        }


        public boolean isSameSet(Node a, Node b) {
            return false;
        }

        public void union(Node a, Node b) {

        }

        public static class Node {
            // whatever you like
        }
    }

}
