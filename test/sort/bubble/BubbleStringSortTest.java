package sort.bubble;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class BubbleStringSortTest {

    @Test
    void sortStrings() {
        // Given
        BubbleStringSort bubble = new BubbleStringSort();
        String[] actual = { "Grenade", "Quiz", "Practice", "Gblogs", "Coding" };
        String[] expected = { "Coding", "Gblogs", "Grenade", "Practice", "Quiz" };
        // When
        String[] result = bubble.sortStrings(actual);
        // Then
        assertArrayEquals(result, expected);
    }
}