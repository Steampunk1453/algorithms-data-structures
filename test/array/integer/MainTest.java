package array.integer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void topKFrequent() {
        // Given
        Main main = new Main();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] expected = {1,2};

        // When
        int[] actual = main.topKFrequent(nums, k);

        // Then
        assertArrayEquals(expected, actual);
    }

    @Test
    void reverseArray() {
        // Given
        Main main = new Main();
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] output = {8, 7, 6, 5, 4, 3, 2, 1};
        // When
        int[] result = main.reverseArray(input);
        // Then
        assertArrayEquals(result, output);
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
        int[] array = {2, 7, 11, 15};
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
        int[] array = {2, 7, 11, 15};
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
        int[] array = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
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
        int[] array = {1, 2, 3, 1};
        // When
        boolean result = main.hasDuplicates(array);
        // Then
        assertTrue(result);
    }

    @Test
    void hasDuplicatesReturnFalse() {
        // Given
        Main main = new Main();
        int[] array = {1, 2, 3, 4};
        // When
        boolean result = main.hasDuplicates(array);
        // Then
        assertFalse(result);
    }

    @Test
    void firstRecurringCharacter() {
        // Given
        Main main = new Main();
        int[] array = {2, 5, 1, 2, 3, 5, 1, 2, 4};
        // When
        Integer result = main.firstRecurringCharacter(array);
        // Then
        assertEquals(result, 2);
    }

    @Test
    void firstRecurringCharacter1() {
        // Given
        Main main = new Main();
        int[] array = {2, 1, 1, 2, 3, 5, 1, 2, 4};
        // When
        Integer result = main.firstRecurringCharacter(array);
        // Then
        assertEquals(result, 1);
    }

    @Test
    void firstRecurringCharacter2() {
        // Given
        Main main = new Main();
        int[] array = {2, 5, 5, 2, 3, 5, 1, 2, 4};
        // When
        Integer result = main.firstRecurringCharacter(array);
        // Then
        assertEquals(result, 5);
    }

    @Test
    void firstRecurringCharacter3() {
        // Given
        Main main = new Main();
        int[] array = {2, 3, 4, 5};
        // When
        Integer result = main.firstRecurringCharacter(array);
        // Then
        assertNull(result);
    }

    @Test
    void singleNumber() {
        // Given
        Main main = new Main();
        int[] array = {2,2,1};
        // When
        Integer result = main.singleNumber(array);
        // Then
        assertEquals(result, 1);
    }

    @Test
    void singleNumber1() {
        // Given
        Main main = new Main();
        int[] array = {4,1,2,1,2};
        // When
        Integer result = main.singleNumber(array);
        // Then
        assertEquals(result, 4);
    }

    @Test
    void singleNumber2() {
        // Given
        Main main = new Main();
        int[] array = {1};
        // When
        Integer result = main.singleNumber(array);
        // Then
        assertEquals(result, 1);
    }

    @Test
    void singleNumberOptimal() {
        // Given
        Main main = new Main();
        int[] array = {2,2,1};
        // When
        Integer result = main.singleNumberOptimal(array);
        // Then
        assertEquals(result, 1);
    }

    @Test
    void singleNumberOptimal1() {
        // Given
        Main main = new Main();
        int[] array = {4,1,2,1,2};
        // When
        Integer result = main.singleNumberOptimal(array);
        // Then
        assertEquals(result, 4);
    }

    @Test
    void singleNumberOptimal2() {
        // Given
        Main main = new Main();
        int[] array = {1};
        // When
        Integer result = main.singleNumberOptimal(array);
        // Then
        assertEquals(result, 1);
    }

    @Test
    void singleNumberOptimal3() {
        // Given
        Main main = new Main();
        int[] array = {-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354};
        // When
        Integer result = main.singleNumberOptimal(array);
        // Then
        assertEquals(result, 354);
    }

    @Test
    void maxAreaBruteForce() {
        // Given
        Main main = new Main();
        int[] height = {1,8,6,2,5,4,8,3,7};
        // When
        int result = main.maxAreaBruteForce(height);
        // Then
        assertEquals(result, 49);
    }

    @Test
    void maxAreaBruteForce1() {
        // Given
        Main main = new Main();
        int[] height = {1,5,6,3,4,2};
        // When
        int result = main.maxAreaBruteForce(height);
        // Then
        assertEquals(result, 12);
    }

    @Test
    void maxAreaBruteForce2() {
        // Given
        Main main = new Main();
        int[] height = {6,9,3,4,5,8};
        // When
        int result = main.maxAreaBruteForce(height);
        // Then
        assertEquals(result, 32);
    }

    @Test
    void maxAreaOptimal() {
        // Given
        Main main = new Main();
        int[] height = {1,8,6,2,5,4,8,3,7};
        // When
        int result = main.maxAreaOptimal(height);
        // Then
        assertEquals(result, 49);
    }

    @Test
    void maxAreaOptimal1() {
        // Given
        Main main = new Main();
        int[] height = {1,5,6,3,4,2};
        // When
        int result = main.maxAreaOptimal(height);
        // Then
        assertEquals(result, 12);
    }

    @Test
    void maxAreaOptimal2() {
        // Given
        Main main = new Main();
        int[] height = {6,9,3,4,5,8};
        // When
        int result = main.maxAreaOptimal(height);
        // Then
        assertEquals(result, 32);
    }

    @Test
    void maxAreaOptimal3() {
        // Given
        Main main = new Main();
        int[] height = {4,8,1,2,3,9};
        // When
        int result = main.maxAreaOptimal(height);
        // Then
        assertEquals(result, 32);
    }

    @Test
    void maxAreaOptimal4() {
        // Given
        Main main = new Main();
        int[] array = {1};
        // When
        Integer result = main.maxAreaOptimal(array);
        // Then
        assertEquals(result, 0);
    }

}