package array.integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntegerMainTest {

    @Test
    void topKFrequent() {
        // Given
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] expected = {1,2};

        // When
        int[] actual = IntegerMain.topKFrequent(nums, k);

        // Then
        assertArrayEquals(expected, actual);
    }

}