package trie.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TrieTest {

    @Test
    void insert() {
        // Given
        Trie trie = new Trie();
        // When
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apples");
        trie.insert("applesauce");
        // Then
        boolean result = trie.search("app");
        assertTrue(result);

    }

    @Test
    void search() {
        // Given
        Trie trie = new Trie();
        // When
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apples");
        trie.insert("applesauce");
        // Then
        boolean result = trie.search("app");
        assertTrue(result);
    }

    @Test
    void searchReturnFalse() {
        // Given
        Trie trie = new Trie();
        // When
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apples");
        trie.insert("applesauce");
        // Then
        boolean result = trie.search("book");
        assertFalse(result);
    }

    @Test
    void startsWith() {
        // Given
        Trie trie = new Trie();
        // When
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apples");
        trie.insert("applesauce");
        // Then
        boolean result = trie.startsWith("ap");
        assertTrue(result);
    }

    @Test
    void startsReturnFalse() {
        // Given
        Trie trie = new Trie();
        // When
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apples");
        trie.insert("applesauce");
        // Then
        boolean result = trie.startsWith("book");
        assertFalse(result);
    }

    @Test
    void getLongestCommonPrefix() {
        // Given
        Trie trie = new Trie();
        String[] input = {"flower","flow","flight"};
        // When
        String result = trie.longestCommonPrefix("fl", input);
        // Then
        assertEquals(result, "fl");
    }
    @Test
    void getLongestCommonPrefix1() {
        // Given
        Trie trie = new Trie();
        String[] input = {"cir", "car"};
        // When
        String result = trie.longestCommonPrefix("c", input);
        // Then
        assertEquals(result, "c");
    }

    @Test
    void getLongestCommonPrefix2() {
        // Given
        Trie trie = new Trie();
        String[] input = {"dog","racecar","car"};
        // When
        String result = trie.longestCommonPrefix("car", input);
        // Then
        assertEquals(result,  "");
    }


}
