package sort.quick;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        // Given
        QuickSort quickSort = new QuickSort();
        int[] array = {10, 7, 8, 9, 1, 5, 2, 4, 3, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int length = array.length;
        // When
        quickSort.sort(array, 0, length - 1);
        // Then
        assertArrayEquals(expected, array);
    }

}