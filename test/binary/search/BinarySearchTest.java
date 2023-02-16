package binary.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    void binarySearch() {
        // Given
        BinarySearch main = new BinarySearch();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // When
        int result = main.binarySearch(numbers, 1);
        // Then
        assertEquals(result, 0);
    }

    @Test
    void binarySearchNotFound() {
        // Given
        BinarySearch main = new BinarySearch();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // When
        int result = main.binarySearch(numbers, 11);
        // Then
        assertEquals(result, -1);
    }

}