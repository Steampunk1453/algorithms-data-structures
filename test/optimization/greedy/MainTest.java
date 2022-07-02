package optimization.greedy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void sortTemperatures() {
        // Given
        Main main = new Main();
        double[] temperatures = {98.6, 98.0, 97.1, 99.0, 98.9, 97.8, 98.5, 98.2, 98.0, 97.1};
        double[] expected = {97.1, 97.8, 98.0, 98.2, 98.5, 98.6, 98.9, 99.0};
        // When
        List<Double> result = main.sortTemperatures(temperatures);
        double[] resultArray = result.stream().mapToDouble(Double::doubleValue).toArray();
        // Then
        assertArrayEquals(resultArray, expected);
    }

}