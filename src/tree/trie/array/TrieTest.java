package tree.trie.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void search1() {
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
    void startsWith1() {
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

}
