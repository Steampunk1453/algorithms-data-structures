package array.string.glovo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getFirstNonRepeatedCharacter() {
        // Given
        Main main = new Main();
        String input = "ABCA";
        // When
       String result = main.getFirstNonRepeatedCharacter(input);
        // Then
        assertEquals(result, "B");
    }

    @Test
    void dontGetFirstNonRepeatedCharacter() {
        // Given
        Main main = new Main();
        String input = "BCABAC";
        // When
        String result = main.getFirstNonRepeatedCharacter(input);
        // Then
        assertNull(result);
    }

    @Test
    void getFirstNonRepeatedCharacterWithEmptyInput() {
        // Given
        Main main = new Main();
        String input = "";
        // When
        String result = main.getFirstNonRepeatedCharacter(input);
        // Then
        assertNull(result);
    }

    @Test
    void isValidString() {
        // Given
        Main main = new Main();
        String input = "()[]{}";
        // When
        boolean result = main.isValidString(input);
        boolean result1 = main.isValidString1(input);
        boolean result2 = main.isValidString2(input);
        // Then
        assertTrue(result);
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void isNotValidString() {
        // Given
        Main main = new Main();
        String input = ")(";
        // When
        boolean result = main.isValidString(input);
        boolean result1 = main.isValidString1(input);
        boolean result2 = main.isValidString2(input);
        // Then
        assertFalse(result);
        assertFalse(result1);
        assertFalse(result2);
    }


}
