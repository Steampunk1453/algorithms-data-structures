package optimization.pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getMissingNumber() {
        // Given
        Main main = new Main();
        int[] numbers = {2, 3, 0, 6, 1, 5};
        int[] numbers1 = {8, 2, 3, 9, 4, 7, 5, 0, 6};
        int[] numbers2 = {1, 2, 3, 4, 5};
        // When
        int result = main.getMissingNumber(numbers);
        int result1 = main.getMissingNumber(numbers1);
        int result2 = main.getMissingNumber(numbers2);
        // Then
        assertEquals(result, 4);
        assertEquals(result1, 1);
        assertEquals(result2, 0);
    }

}