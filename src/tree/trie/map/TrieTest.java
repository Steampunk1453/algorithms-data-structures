package tree.trie.map;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrieTest {

    @Test
    void insert() {
        // Given
        List<String> words = List.of("hello", "dog", "hell", "cat", "a", "hel", "help","helps","helping");
        Trie trie = new Trie(words);
        // When
        boolean result = trie.find("help");
        // Then
        assertTrue(result);
    }

    @Test
    void insert1() {
        // Given
        List<String> words = List.of("hello", "dog", "hell", "cat", "a", "hel", "help","helps","helping");
        Trie trie = new Trie(words);
        // When
        boolean result = trie.find("dogg");
        // Then
        assertFalse(result);
    }

    @Test
    void suggest() {
        // Given
        List<String> words = List.of("hello", "dog", "hell", "cat", "a", "hel", "help","helps","helping");
        Trie trie = new Trie(words);
        // When
        List<String> result = trie.suggest("hel");
        // Then
        assertTrue(result.contains("hello"));
        assertTrue(result.contains("hell"));
        assertTrue(result.contains("hel"));
        assertTrue(result.contains("help"));
        assertTrue(result.contains("helps"));
        assertTrue(result.contains("helping"));
    }

    @Test
    void suggest1() {
        // Given
        List<String> words = List.of("hello", "dog", "hell", "cat", "a", "hel", "help","helps","helping");
        Trie trie = new Trie(words);
        // When
        List<String> result = trie.suggest("bo");
        // Then
        assertTrue(result.isEmpty());
    }

}