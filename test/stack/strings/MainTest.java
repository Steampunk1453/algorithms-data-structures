package stack.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void reverseString() {
        // Given
        Main main = new Main();
        String input = "abcde";
        // When
        String result = main.reverseString(input);
        // Then
        assertEquals(result, "edcba");
    }

    @Test
    void isValidString() {
        // Given
        Main main = new Main();
        String input = "(((((((((())))))))))";
        // When
        boolean result = main.isValidString(input);
        // Then
        assertTrue(result);
    }

    @Test
    void isNotValidString() {
        // Given
        Main main = new Main();
        String input = "([)])";
        // When
        boolean result = main.isValidString(input);
        // Then
        assertFalse(result);
    }

}