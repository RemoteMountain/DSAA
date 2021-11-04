package com.niuke.practice.basic.day7;

/**
 * 前缀树
 */
public class TrieTree {


    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.nexts[index] == null){
                TrieNode newNode = new TrieNode();
                node.nexts[index] = newNode;
            }
            node = node.nexts[index];
            node.path++;
        }
        node.end++;
    }

    public void delete(String word) {

    }

    public int search(String word) {
        return 0;
    }

    public int prefixNumber(String pre) {
        return 0;
    }

    public static class TrieNode {
        private int path;
        private int end;
        private TrieNode[] nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
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
