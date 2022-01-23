package sort.bubble;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSortTest {

    @Test
    void sort() {
        // Given
        BubbleSort main = new BubbleSort();
        int[] array = {4, 2, 7, 1, 3};
        // When
        int[] result = main.sort(array);
        // Then
        assertEquals(result[0], 1);
    }
}