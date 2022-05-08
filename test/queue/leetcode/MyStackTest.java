package queue.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void push() {
        // Given
        MyStack stack = new MyStack();
        // When
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // Then
        assertEquals(stack.queue.size(), 4);
    }

    @Test
    void pop() {
        // Given
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // When
        int result = stack.pop();
        // Then
        assertEquals(result, 4);
        assertEquals(stack.queue.size(), 3);
    }

    @Test
    void top() {
        // Given
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // When
        int result = stack.top();
        // Then
        assertEquals(result, 4);
        assertEquals(stack.queue.size(), 4);
    }

    @Test
    void isEmpty() {
        // Given
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        // When
        boolean result = stack.isEmpty();
        // Then
        assertTrue(result);
        assertEquals(stack.queue.size(), 0);
    }

    @Test
    void isNotEmpty() {
        // Given
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // When
        boolean result = stack.isEmpty();
        // Then
        assertFalse(result);
        assertEquals(stack.queue.size(), 4);
    }

}