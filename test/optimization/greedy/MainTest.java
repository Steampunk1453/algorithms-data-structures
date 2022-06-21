package optimization.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getHighestProduct() {
        // Given
        Main main = new Main();
        int[] numbers = {5, -10, -6, 9, 4};
        int[] numbers1 = {-9, -2, -1, 2, 3, 7};
        int[] numbers2 = {-7, -4, -3, 0, 4, 6};
        // When
        int result = main.getHighestProduct(numbers);
        int result1 = main.getHighestProduct(numbers1);
        int result2 = main.getHighestProduct(numbers2);
        // Then
        assertEquals(result, 60);
        assertEquals(result1, 21);
        assertEquals(result2, 28);

    }
}