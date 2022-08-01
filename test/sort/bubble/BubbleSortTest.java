package sort.bubble;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

    @Test
    void sortWithWhile() {
        // Given
        BubbleSort bubble = new BubbleSort();
        int[] actual = {4, 2, 7, 1, 3};
        int[] expected = {1, 2, 3, 4, 7};
        // When
        int[] result = bubble.sortWithWhile(actual);
        // Then
        assertArrayEquals(result, expected);
    }

    @Test
    void sortWithFor() {
        // Given
        BubbleSort bubble = new BubbleSort();
        int[] actual = {4, 2, 7, 1, 3};
        int[] expected = {1, 2, 3, 4, 7};
        // When
        int[] result = bubble.sortWithFor(actual);
        // Then
        assertArrayEquals(result, expected);
    }

}