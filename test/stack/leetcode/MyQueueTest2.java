package stack.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MyQueueTest2 {

    @Test
    void push() {
        // Given
        MyQueue2 queue = new MyQueue2();
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
        MyQueue2 queue = new MyQueue2();
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
        MyQueue2 queue = new MyQueue2();
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
        MyQueue2 queue = new MyQueue2();
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
        MyQueue2 queue = new MyQueue2();
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
        MyQueue2 queue = new MyQueue2();
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