package queue.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    void push() {
        // Given
        MyQueue queue = new MyQueue();
        // When
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        // Then
        assertEquals(queue.stack1.size(), 4);
    }

    @Test
    void pop() {
        // Given
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        // When
        int result = queue.pop();
        // Then
        assertEquals(result, 1);
        assertEquals(queue.stack1.size(), 3);
    }

    @Test
    void peek() {
        // Given
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.pop();
        queue.pop();
        // When
        int result = queue.peek();
        // Then
        assertEquals(result, 3);
        assertEquals(queue.stack1.size(), 2);
    }

    @Test
    void isEmpty() {
        // Given
        MyQueue queue = new MyQueue();
        // When
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        // When
        boolean result = queue.isEmpty();
        // Then
        assertTrue(result);
        assertEquals(queue.stack1.size(), 0);
    }

    @Test
    void isNotEmpty() {
        // Given
        MyQueue queue = new MyQueue();
        // When
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        // When
        boolean result = queue.isEmpty();
        // Then
        assertFalse(result);
        assertEquals(queue.stack1.size(), 4);
    }

    @Test
    void all() {
        // Given
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.pop();
        queue.pop();
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.pop();
        queue.push(6);
        queue.pop();
        queue.pop();
        // When
        int result = queue.peek();
        // Then
        assertEquals(result, 6);
        assertEquals(queue.stack1.size(), 1);
    }

}