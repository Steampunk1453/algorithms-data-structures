package sort.quick;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSelectTest {

    @Test
    void kthSmallest() {
        // Given
        QuickSelect quickSelect = new QuickSelect();
        int[] array = {10, 4, 5, 8, 6, 11, 26};
        int length = array.length;
        int k = 3;

        // When
        int result = quickSelect.kthSmallest(array, 0, length - 1, k);

        // Then
        assertEquals(6, result);
    }

}