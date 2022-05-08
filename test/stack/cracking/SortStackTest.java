package stack.cracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortStackTest {

    @Test
    void push() {
        // Given
        SortStack stack = new SortStack();
        // When
        stack.pushQueueOrder(2);
        stack.pushQueueOrder(3);
        stack.pushQueueOrder(4);
        stack.pushQueueOrder(1);
        // Then
        assertEquals(stack.stack.size(), 4);
    }

    @Test
    void push1() {
        // Given
        SortStack stack = new SortStack();
        // When
        stack.pushQueueOrder(2);
        stack.pushQueueOrder(4);
        stack.pushQueueOrder(1);
        stack.pushQueueOrder(3);
        stack.pushQueueOrder(5);
        // Then
        assertEquals(stack.stack.size(), 5);
    }

    @Test
    void push2() {
        // Given
        SortStack stack = new SortStack();
        // When
        stack.pushQueueOrder(5);
        stack.pushQueueOrder(7);
        stack.pushQueueOrder(4);
        stack.pushQueueOrder(3);
        stack.pushQueueOrder(9);
        stack.pushQueueOrder(2);
        // Then
        assertEquals(stack.stack.size(), 6);
    }

    @Test
    void pop() {
        // Given
        SortStack stack = new SortStack();
        stack.pushQueueOrder(2);
        stack.pushQueueOrder(3);
        stack.pushQueueOrder(4);
        stack.pushQueueOrder(1);
        // When
        int result = stack.pop();
        // Then
        assertEquals(result, 4);
    }

    @Test
    void peek() {
        // Given
        SortStack stack = new SortStack();
        stack.pushQueueOrder(2);
        stack.pushQueueOrder(4);
        stack.pushQueueOrder(1);
        stack.pushQueueOrder(3);
        stack.pushQueueOrder(5);
        // When
        int result = stack.peek();
        // Then
        assertEquals(result, 5);
    }

    @Test
    void isEmpty() {
        // Given
        SortStack stack = new SortStack();
        stack.pushQueueOrder(2);
        stack.pushQueueOrder(3);
        stack.pushQueueOrder(4);
        stack.pushQueueOrder(1);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        // When
        boolean result = stack.isEmpty();
        // Then
        assertTrue(result);
    }

    @Test
    void isNotEmpty() {
        // Given
        SortStack stack = new SortStack();
        stack.pushQueueOrder(2);
        stack.pushQueueOrder(3);
        stack.pushQueueOrder(4);
        stack.pushQueueOrder(1);
        // When
        boolean result = stack.isEmpty();
        // Then
        assertFalse(result);
    }

}