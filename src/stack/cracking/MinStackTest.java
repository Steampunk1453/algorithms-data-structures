package stack.cracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void push() {
        // Given
        MinStack stack = new MinStack();
        // When
        stack.push(7);
        stack.push(4);
        stack.push(9);
        stack.push(3);
        stack.push(6);
        stack.push(2);
        stack.push(10);
        // Then
        assertEquals(stack.stack.size(), 7);
    }

    @Test
    void pop() {
        // Given
        MinStack stack = new MinStack();
        stack.push(7);
        stack.push(4);
        stack.push(9);
        stack.push(3);
        stack.push(6);
        stack.push(2);
        stack.push(10);
        // When
        int result = stack.pop();
        // Then
        assertEquals(result, 10);
    }

    @Test
    void min() {
        // Given
        MinStack stack = new MinStack();
        stack.push(7);
        stack.push(4);
        stack.push(9);
        stack.push(3);
        stack.push(6);
        stack.push(2);
        stack.push(10);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        // When
        int result = stack.min();
        // Then
        assertEquals(result, 4);
    }

    @Test
    void min1() {
        // Given
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        stack.pop();
        // When
        int result = stack.min();
        // Then
        assertEquals(result, 2);
    }

}