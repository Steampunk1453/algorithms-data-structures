package array.string.udemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    void reverseString() {
        // Given
        Main main = new Main();
        // When
        String result = main.reverse("Hello");
        // Then
        assertEquals(result, "olleH");
    }

    @Test
    void reverseStringReturnEmpty() {
        // Given
        Main main = new Main();
        // When
        String result = main.reverse("");
        // Then
        assertEquals(result, "");
    }

    @Test
    void mergeSortedArrays() {
        // Given
        Main main = new Main();
        int[] array1 = {0, 3, 4, 31};
        int[] array2 = {4, 6, 30};
        int[] expected = {0, 3, 4, 4, 6, 30, 31};
        // When
        int[] result = main.merge(array1, array2);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void mergeSortedArraysBis() {
        // Given
        Main main = new Main();
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        // When
        int[] result = main.merge(array1, array2);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void twoSumBruteForce() {
        // Given
        Main main = new Main();
        int[] array = {2,7,11,15};
        int target = 9;
        int[] expected = {0, 1};
        // When
        int[] result = main.twoSumBruteForce(array, target);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void twoSumBruteForce1() {
        // Given
        Main main = new Main();
        int[] array = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};
        // When
        int[] result = main.twoSumBruteForce(array, target);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void twoSumBruteForce2() {
        // Given
        Main main = new Main();
        int[] array = {3, 3};
        int target = 6;
        int[] expected = {0, 1};
        // When
        int[] result = main.twoSumBruteForce(array, target);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void twoSumBruteForce3() {
        // Given
        Main main = new Main();
        int[] array = {7, 2, 13, 11, 8};
        int target = 24;
        int[] expected = {2, 3};
        // When
        int[] result = main.twoSumBruteForce(array, target);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void twoSum() {
        // Given
        Main main = new Main();
        int[] array = {2,7,11,15};
        int target = 9;
        int[] expected = {0, 1};
        // When
        int[] result = main.twoSum(array, target);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void twoSum1() {
        // Given
        Main main = new Main();
        int[] array = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};
        // When
        int[] result = main.twoSum(array, target);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void twoSum2() {
        // Given
        Main main = new Main();
        int[] array = {3, 3};
        int target = 6;
        int[] expected = {0, 1};
        // When
        int[] result = main.twoSum(array, target);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void twoSum3() {
        // Given
        Main main = new Main();
        int[] array = {7, 2, 13, 11, 8};
        int target = 24;
        int[] expected = {2, 3};
        // When
        int[] result = main.twoSum(array, target);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void moveZeroes() {
        // Given
        Main main = new Main();
        int[] array = {0,1,0,3,12};
        int[] expected = {1,3,12,0,0};
        // When
        int[] result = main.moveZeroes(array);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void moveZeroes1() {
        // Given
        Main main = new Main();
        int[] array = {0};
        int[] expected = {0};
        // When
        int[] result = main.moveZeroes(array);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void hasDuplicates() {
        // Given
        Main main = new Main();
        int[] array = {1,2,3,1};
        // When
       boolean result = main.hasDuplicates(array);
        // Then
        assertTrue(result);
    }

    @Test
    void hasDuplicatesReturnFalse() {
        // Given
        Main main = new Main();
        int[] array = {1,2,3,4};
        // When
        boolean result = main.hasDuplicates(array);
        // Then
        assertFalse(result);
    }

    @Test
    void getLongestWord() {
        // Given
        Main main = new Main();
        String input = "I love dogs";
        // When
        String result = main.getLongestWord(input);
        // Then
        assertEquals(result, "love");
    }

    @Test
    void getLongestWord1() {
        // Given
        Main main = new Main();
        String input = "Hello world123 567";
        // When
        String result = main.getLongestWord(input);
        // Then
        assertEquals(result, "world123");
    }

    @Test
    void getLongestWord2() {
        // Given
        Main main = new Main();
        String input = "fun&!! time";
        // When
        String result = main.getLongestWord(input);
        // Then
        assertEquals(result, "time");
    }

}
