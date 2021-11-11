package stack.linked.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void pushInt() {
        // Given
        Stack<Integer> stack = new Stack<>();
        // When
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // Then
        assertEquals(stack.top.data, 4);
        assertEquals(stack.size, 4);
    }

    void pushString() {
        // Given
        Stack<String> stack = new Stack<>();
        // When
        stack.push("Google");
        stack.push("Amazon");
        stack.push("Microsoft");
        stack.push("Facebook");
        // Then
        assertEquals(stack.top.data, "Facebook");
        assertEquals(stack.size, 4);
    }

    @Test
    void popInt() {
        // Given
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // When
        int result = stack.pop();
        // Then
        assertEquals(result, 4);
        assertEquals(stack.size, 3);
    }
    @Test
    void popString() {
        // Given
        Stack<String> stack = new Stack<>();
        // When
        stack.push("Google");
        stack.push("Amazon");
        stack.push("Microsoft");
        stack.push("Facebook");
        // When
        String result = stack.pop();
        // Then
        assertEquals(result, "Facebook");
        assertEquals(stack.size, 3);
    }


    @Test
    void peekInt() {
        // Given
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // When
        int result = stack.peek();
        // Then
        assertEquals(result, 4);
        assertEquals(stack.size, 4);
    }

    @Test
    void peekString() {
        // Given
        Stack<String> stack = new Stack<>();
        // When
        stack.push("Google");
        stack.push("Amazon");
        stack.push("Microsoft");
        stack.push("Facebook");
        // When
        String result = stack.peek();
        // Then
        assertEquals(result, "Facebook");
        assertEquals(stack.size, 4);
    }

    @Test
    void isEmptyInt() {
        // Given
        Stack<Integer> stack = new Stack<>();
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
        assertEquals(stack.size, 0);
    }


    @Test
    void isEmptyString() {
        // Given
        Stack<String> stack = new Stack<>();
        // When
        stack.push("Google");
        stack.push("Amazon");
        stack.push("Microsoft");
        stack.push("Facebook");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        // When
        boolean result = stack.isEmpty();
        // Then
        assertTrue(result);
        assertEquals(stack.size, 0);
    }

    @Test
    void isNotEmptyInt() {
        // Given
        Stack<Integer> stack = new Stack<>();
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

    @Test
    void isNotEmptyString() {
        // Given
        Stack<String> stack = new Stack<>();
        // When
        stack.push("Google");
        stack.push("Amazon");
        stack.push("Microsoft");
        stack.push("Facebook");
        // When
        boolean result = stack.isEmpty();
        // Then
        assertFalse(result);
        assertEquals(stack.size, 4);
    }

}