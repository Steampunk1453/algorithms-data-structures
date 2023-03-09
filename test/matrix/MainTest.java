package matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void numIslandsBFS() {
        // Given
        Main main = new Main();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        // When
        int expected = 3;
        int actual = main.numIslandsBFS(grid);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    void numIslandsDFS() {
        // Given
        Main main = new Main();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        // When
        int expected = 3;
        int actual = main.numIslandsDFS(grid);
        // Then
        assertEquals(expected, actual);
    }

}