package hash.table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MainTest {

    @Test
    void getIntersection() {
        // Given
        Main main = new Main();
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {0, 2, 4, 6, 8};
        // When
        List<Integer> result = main.getIntersection(array1, array2);
        // Then
        assertEquals(result.get(0), 2);
        assertEquals(result.get(1), 4);
    }

    @Test
    void getFirstDuplicate() {
        // Given
        Main main = new Main();
        String[] array = {"a", "b", "c", "d", "c", "e", "f"};
        // When
        String result = main.getFirstDuplicate(array);
        // Then
        assertEquals(result, "c");
    }

    @Test
    void getFirstDuplicateReturnNull() {
        // Given
        Main main = new Main();
        String[] array = {"a", "b", "c", "d", "e", "f", "g"};
        // When
        String result = main.getFirstDuplicate(array);
        // Then
        assertNull(result);
    }

    @Test
    void getMissingLetter() {
        // Given
        Main main = new Main();
        String input = "the quick brown box jumps over a lazy dog";
        // When
        String result = main.getMissingLetter(input);
        // Then
        assertEquals(result, "f");
    }

    @Test
    void getMissingLetterReturnNull() {
        // Given
        Main main = new Main();
        String input = "the quick brown box jumps over a lazy dogf";
        // When
        String result = main.getMissingLetter(input);
        // Then
        assertNull(result);
    }

    @Test
    void getFirstNonDuplicatedCharacter() {
        // Given
        Main main = new Main();
        String input = "minimum";
        // When
        String result = main.getFirstNonDuplicatedCharacter(input);
        // Then
        assertEquals(result, "n");
    }

    @Test
    void getFirstNonDuplicatedCharacterReturnNull() {
        // Given
        Main main = new Main();
        String input = "minnimumu";
        // When
        String result = main.getFirstNonDuplicatedCharacter(input);
        // Then
        assertNull(result);
    }

}