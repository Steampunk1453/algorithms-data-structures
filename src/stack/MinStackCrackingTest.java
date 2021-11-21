package stack;

import org.junit.jupiter.api.Test;
import stack.leetcode.MyQueue;

import static org.junit.jupiter.api.Assertions.*;

class MinStackCrackingTest {

    @Test
    void push() {
        // Given
        MinStackCracking stack = new MinStackCracking();
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
        MinStackCracking stack = new MinStackCracking();
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
        MinStackCracking stack = new MinStackCracking();
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
        MinStackCracking stack = new MinStackCracking();
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