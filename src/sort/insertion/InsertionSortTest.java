package sort.insertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertionSortTest {

    @Test
    void insertion() {
        // Given
        InsertionSort main = new InsertionSort();
        int[] array = {4, 2, 7, 1, 3};
        // When
        int[] result = main.insertion(array);
        // Then
        assertEquals(result[0], 1);
    }
}