package stack.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void push() {
        // Given
        MinStack stack = new MinStack(4);
        // When
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        // Then
        assertEquals(stack.size, 3);
    }

    @Test
    void pop() {
        // Given
        MinStack stack = new MinStack(4);
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        // When
       stack.pop();
        // Then
        assertEquals(stack.size, 2);
    }

    @Test
    void top() {
        // Given
        MinStack stack = new MinStack(4);
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        // When
        Integer result = stack.top();
        // Then
        assertEquals(result, -3);
        assertEquals(stack.size, 3);
    }

    @Test
    void getMin() {
        // Given
        MinStack stack = new MinStack(4);
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.getMin();
        stack.pop();
        // When
        int result = stack.getMin();
        // Then
        assertEquals(result, -2);
        assertEquals(stack.size, 2);
    }
}