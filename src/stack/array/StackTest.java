package stack.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void push() {
        // Given
        Stack stack = new Stack(4);
        // When
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // Then
        assertEquals(stack.items.length, 4);
        assertEquals(stack.size, 4);
    }

    @Test
    void pop() {
        // Given
        Stack stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // When
        Integer result = stack.pop();
        // Then
        assertEquals(result, 4);
        assertEquals(stack.size, 3);
    }

    @Test
    void peek() {
        // Given
        Stack stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // When
        Integer result = stack.peek();
        // Then
        assertEquals(result, 4);
        assertEquals(stack.size, 4);
    }

    @Test
    void isEmpty() {
        // Given
        Stack stack = new Stack(4);
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
        assertEquals(stack.size, 0);
        // Then
        assertTrue(result);
    }

    @Test
    void isNotyEmpty() {
        // Given
        Stack stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // When
        boolean result = stack.isEmpty();
        // Then
        assertFalse(result);
        assertEquals(stack.size, 4);
    }

}