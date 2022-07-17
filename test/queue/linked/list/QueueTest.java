package queue.linked.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void addInt() {
        // Given
        Queue<Integer> queue = new Queue<>();
        // When
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
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
        queue.enqueue2("Google");
        queue.enqueue2("Amazon");
        queue.enqueue2("Microsoft");
        queue.enqueue2("Facebook");
        // Then
        assertEquals(queue.first.data, "Google");
        assertEquals(queue.last.data, "Facebook");
        assertEquals(queue.size, 4);
    }

    @Test
    void removeInt() {
        // Given
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        // When
        int result = queue.dequeue();
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
        queue.enqueue("Google");
        queue.enqueue("Amazon");
        queue.enqueue("Microsoft");
        queue.enqueue("Facebook");
        // When
        String result = queue.dequeue();
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
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
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
        queue.enqueue("Google");
        queue.enqueue("Amazon");
        queue.enqueue("Microsoft");
        queue.enqueue("Facebook");
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
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
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
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
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
        queue.enqueue("Google");
        queue.enqueue("Amazon");
        queue.enqueue("Microsoft");
        queue.enqueue("Facebook");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
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
        queue.enqueue("Google");
        queue.enqueue("Amazon");
        queue.enqueue("Microsoft");
        queue.enqueue("Facebook");
        // When
        boolean result = queue.isEmpty();
        // Then
        assertFalse(result);
        assertEquals(queue.size, 4);
    }

}