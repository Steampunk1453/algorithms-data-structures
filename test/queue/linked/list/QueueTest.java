package queue.linked.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void addInt() {
        // Given
        Queue<Integer> queue = new Queue<>();
        // When
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        // Then
        assertEquals(queue.first.data, 1);
        assertEquals(queue.last.data, 4);
        assertEquals(queue.size, 4);
    }

    @Test
    void addString() {
        // Given
        Queue<String> queue = new Queue<>();
        // When
        queue.add("Google");
        queue.add("Amazon");
        queue.add("Microsoft");
        queue.add("Facebook");
        // Then
        assertEquals(queue.first.data, "Google");
        assertEquals(queue.last.data, "Facebook");
        assertEquals(queue.size, 4);
    }

    @Test
    void removeInt() {
        // Given
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        // When
        int result = queue.remove();
        // Then
        assertEquals(result, 1);
        assertEquals(queue.first.data, 2);
        assertEquals(queue.last.data, 4);
        assertEquals(queue.size, 3);
    }


    @Test
    void removeString() {
        // Given
        Queue<String> queue = new Queue<>();
        queue.add("Google");
        queue.add("Amazon");
        queue.add("Microsoft");
        queue.add("Facebook");
        // When
        String result = queue.remove();
        // Then
        assertEquals(result, "Google");
        assertEquals(queue.first.data, "Amazon");
        assertEquals(queue.last.data, "Facebook");
        assertEquals(queue.size, 3);
    }

    @Test
    void peekInt() {
        // Given
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        // When
        int result = queue.peek();
        // Then
        assertEquals(result, 1);
        assertEquals(queue.size, 4);
    }

    @Test
    void  peekString() {
        // Given
        Queue<String> queue = new Queue<>();
        queue.add("Google");
        queue.add("Amazon");
        queue.add("Microsoft");
        queue.add("Facebook");
        // When
        String result = queue.peek();
        // Then
        assertEquals(result, "Google");
        assertEquals(queue.size, 4);
    }

    @Test
    void peekIntIsEmpty() {
        // Given
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        // When
        boolean result = queue.isEmpty();
        // Then
        assertTrue(result);
        assertEquals(queue.size, 0);
    }

    @Test
    void peekIntIsNotEmpty() {
        // Given
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        // When
        boolean result = queue.isEmpty();
        // Then
        assertFalse(result);
        assertEquals(queue.size, 4);
    }

    @Test
    void  peekStringIsEmpty() {
        // Given
        Queue<String> queue = new Queue<>();
        queue.add("Google");
        queue.add("Amazon");
        queue.add("Microsoft");
        queue.add("Facebook");
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        // When
        boolean result = queue.isEmpty();
        // Then
        assertTrue(result);
        assertEquals(queue.size, 0);
    }

    @Test
    void  peekStringIsNotEmpty() {
        // Given
        Queue<String> queue = new Queue<>();
        queue.add("Google");
        queue.add("Amazon");
        queue.add("Microsoft");
        queue.add("Facebook");
        // When
        boolean result = queue.isEmpty();
        // Then
        assertFalse(result);
        assertEquals(queue.size, 4);
    }

}