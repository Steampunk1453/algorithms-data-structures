package sort.merge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void merge() {
        // Given
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        // When
        MergeSort.mergeSort(actual, actual.length);
        // Then
        assertArrayEquals(expected, actual);
    }

}