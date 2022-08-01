package sort.heap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class HeapSortTest {

    @Test
    void sort() {
        // Given
        HeapSort heap = new HeapSort();
        int[] actual = { 12, 11, 13, 5, 6, 7 };
        int[] expected = {5, 6, 7, 11, 12, 13};
        // When
        int[] result = heap.sort(actual);
        // Then
        assertArrayEquals(result, expected);
    }
}