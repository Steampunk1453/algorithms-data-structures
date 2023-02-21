package binary.search;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
        assertEquals(0, result);
    }

    @Test
    void binarySearchNotFound() {
        // Given
        BinarySearch main = new BinarySearch();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // When
        int result = main.binarySearch(numbers, 11);
        // Then
        assertEquals(-1, result);
    }

    @Test
    void searchRange() {
        // Given
        BinarySearch main = new BinarySearch();
        int[] nums = {1, 3, 3, 5, 6, 8, 9};
        int target = 3;
        int[] expected = {1, 2};
        // When
        int[] result = main.searchRange(nums, target);
        // Then
        assertArrayEquals(expected, result);
    }

    @Test
    void searchRange1() {
        // Given
        BinarySearch main = new BinarySearch();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expected = {3, 4};
        // When
        int[] result = main.searchRange(nums, target);
        // Then
        assertArrayEquals(expected, result);
    }

    @Test
    void searchRangeNotFound() {
        // Given
        BinarySearch main = new BinarySearch();
        int[] nums = {2, 4, 7, 8, 10};
        int target = 5;
        int[] expected = {-1, -1};
        // When
        int[] result = main.searchRange(nums, target);
        // Then
        assertArrayEquals(expected, result);
    }

    @Test
    void searchRangeNotFound1() {
        // Given
        BinarySearch main = new BinarySearch();
        int[] nums = {};
        int target = 0;
        int[] expected = {-1, -1};
        // When
        int[] result = main.searchRange(nums, target);
        // Then
        assertArrayEquals(expected, result);
    }

}