package trie;

import trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TrieOperations {

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;
    public TrieOperations() {
        root = new TrieNode();
    }

    /**
     * Iterative implementation of insert into trie
     */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!Character.isAlphabetic(ch)){ // if seached by lm.. or ab..
                continue;
            }

            TrieNode node = current.children.get(ch);
            //if node does not exist for given char then return false
            if (node == null) {
                return false;
            }
            current = node;
        }
        //return true of current's endOfWord is true else return false.
        //return current.endOfWord;
        return true;
    }


    public static void main(String args[]){

        //https://www.youtube.com/watch?v=AXjmTQ8LEoI&t=239s
        TrieOperations  trieOperations = new TrieOperations();
        trieOperations.insert("abc");
        trieOperations.insert("abcdl");
        trieOperations.insert("lmn");
        for (Map.Entry<Character,TrieNode> t : trieOperations.root.children.entrySet()){
            System.out.println(t.getKey()+":"+t.getValue());

        }
        System.out.println(trieOperations.search("lm.."));
    }
}
