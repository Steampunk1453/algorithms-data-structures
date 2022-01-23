package sort.selection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void sort() {
        // Given
        SelectionSort main = new SelectionSort();
        int[] array = {4, 2, 7, 1, 3};
        // When
        int[] result = main.sort(array);
        // Then
        assertEquals(result[0], 1);
    }
}