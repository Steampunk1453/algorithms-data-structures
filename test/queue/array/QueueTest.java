package queue.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void add() {
        // Given
       Queue queue = new Queue(5);
        // When
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        // Then
        assertEquals(queue.items[0], 1);
        assertEquals(queue.size, 4);
    }

    @Test
    void remove() {
        // Given
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        // When
        Integer result = queue.dequeue();
        // Then
        assertEquals(result, 1);
        assertEquals(queue.items[0], 2);
        assertEquals(queue.size, 3);
    }

    @Test
    void peek() {
        // Given
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        // When
        Integer result = queue.peek();
        // Then
        assertEquals(result, 1);
        assertEquals(queue.size, 4);
    }

    @Test
    void isEmpty() {
        // Given
        Queue queue = new Queue(5);
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
    void isNoEmpty() {
        // Given
        Queue queue = new Queue(5);
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

}