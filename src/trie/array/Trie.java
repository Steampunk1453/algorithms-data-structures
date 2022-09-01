package trie.array;

public class Trie {

    // Using trie has only O(m) time complexity, where m is the key length.
    // Searching for a key in a balanced tree costs O(mlogn) time complexity.
    // Leetcode impl
    public static final int ALPHABET_SIZE = 26;

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static class TrieNode {
        TrieNode[] child;
        boolean isEnd;
        private int size;

        public TrieNode() {
            child = new TrieNode[ALPHABET_SIZE];
            isEnd = false;
        }

        private boolean containsKey(char ch) {
            return child[ch -'a'] != null;
        }

        private TrieNode get(char ch) {
            return child[ch -'a'];
        }

        private void put(char ch, TrieNode node) {
            child[ch -'a'] = node;
            size++;
        }

        private void setEnd() {
            isEnd = true;
        }

        private boolean isEnd() {
            return isEnd;
        }
    }

    // Inserts a word into the trie.
    protected void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    // Returns if the word is in the trie.
    protected boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    protected boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    // Time complexity: O(S⋅logm)
    // Space complexity: O(1)
    public String longestCommonPrefix(String q, String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        Trie trie = new Trie();
        for (int i = 1; i < strs.length ; i++) {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(q);
    }

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    private String searchLongestPrefix(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter) && (node.size == 1) && (!node.isEnd())) {
                prefix.append(curLetter);
                node = node.get(curLetter);
            }
            else
                return prefix.toString();

        }
        return prefix.toString();
    }

}
