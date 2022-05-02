package tree.trie.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    TrieNode root;

    public Trie(List<String> words) {
        root = new TrieNode();
        for (String word : words)
            root.insert(word);
    }

    public static class TrieNode {

        Map<Character, TrieNode> children;
        char ch;
        boolean isWord;

        public TrieNode(char ch) {
            this.ch = ch;
            children = new HashMap<>();
        }

        public TrieNode() {
            children = new HashMap<>();
        }

        protected void insert(String word) {
            if (word == null || word.isEmpty())
                return;
            char firstChar = word.charAt(0);
            TrieNode child = children.get(firstChar);
            if (child == null) {
                child = new TrieNode(firstChar);
                children.put(firstChar, child);
            }

            if (word.length() > 1)
                child.insert(word.substring(1));
            else
                child.isWord = true;
        }

    }

    protected boolean find(String prefix) {
        return find(prefix, false);
    }

    private boolean find(String prefix, boolean exact) {
        TrieNode lastNode = root;
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return false;
        }
        return !exact || lastNode.isWord;
    }

    protected List<String> suggest(String prefix) {
        List<String> list = new ArrayList<>();
        TrieNode lastNode = root;
        StringBuffer current = new StringBuffer();

        for (char ch : prefix.toCharArray()) {
            lastNode = lastNode.children.get(ch);
            if (lastNode == null) {
                return list;
            }
            current.append(ch);
        }
        suggestHelper(lastNode, list, current);
        return list;
    }

    private void suggestHelper(TrieNode root, List<String> list, StringBuffer current) {
        if (root.isWord) {
            list.add(current.toString());
        }

        if (root.children == null || root.children.isEmpty())
            return;

        for (TrieNode child : root.children.values()) {
            suggestHelper(child, list, current.append(child.ch));
            current.setLength(current.length() - 1);
        }

    }

}
