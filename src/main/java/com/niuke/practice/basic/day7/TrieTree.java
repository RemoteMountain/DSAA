package com.niuke.practice.basic.day7;

/**
 * 前缀树
 */
public class TrieTree {
    public static class TrieNode {
        private int path;
        private int end;
        private TrieNode[] nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];
        }

        public static class Trie {
            private TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String word) {

            }

            public void delete(String word) {

            }

            public int search(String word) {
                return 0;
            }

            public int prefixNumber(String pre) {
                return 0;
            }

            public static void main(String[] args) {
                Trie trie = new Trie();
                System.out.println(trie.search("zuo"));
                trie.insert("zuo");
                System.out.println(trie.search("zuo"));
                trie.delete("zuo");
                System.out.println(trie.search("zuo"));
                trie.insert("zuo");
                trie.insert("zuo");
                trie.delete("zuo");
                System.out.println(trie.search("zuo"));
                trie.delete("zuo");
                System.out.println(trie.search("zuo"));
                trie.insert("zuoa");
                trie.insert("zuoac");
                trie.insert("zuoab");
                trie.insert("zuoad");
                trie.delete("zuoa");
                System.out.println(trie.search("zuoa"));
                System.out.println(trie.prefixNumber("zuo"));
            }
        }
    }


}
