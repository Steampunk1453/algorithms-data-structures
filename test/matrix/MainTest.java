package matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        int expected = 3;
        // When
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
        int expected = 3;
        // When
        int actual = main.numIslandsDFS(grid);
        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void orangesRottingBFS() {
        // Given
        Main main = new Main();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int expected = 4;
        // When
        int result = main.orangesRottingBFS(grid);
        // Then
        assertEquals(expected, result);
    }

    @Test
    public void orangesRottingBFS1() {
        // Given
        Main main = new Main();
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        int expected = -1;
        // When
        int result = main.orangesRottingBFS(grid);
        // Then
        assertEquals(expected, result);
    }

    @Test
    public void orangesRottingBFS2() {
        // Given
        Main main = new Main();
        int[][] grid = {{0,2}};
        int expected = 0;
        // When
        int result = main.orangesRottingBFS(grid);
        // Then
        assertEquals(expected, result);
    }

    @Test
    public void orangesRottingDFS() {
        // Given
        Main main = new Main();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int expected = 4;
        // When
        int result = main.orangesRottingDFS(grid);
        // Then
        assertEquals(expected, result);
    }

    @Test
    public void orangesRottingDFS1() {
        // Given
        Main main = new Main();
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        int expected = -1;
        // When
        int result = main.orangesRottingDFS(grid);
        // Then
        assertEquals(expected, result);
    }

    @Test
    public void orangesRottingDFS2() {
        // Given
        Main main = new Main();
        int[][] grid = {{0,2}};
        int expected = 0;
        // When
        int result = main.orangesRottingDFS(grid);
        // Then
        assertEquals(expected, result);
    }

    @Test
    public void testWallsAndGatesDFS() {
        // Given
        Main main = new Main();
        int[][] rooms = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        int[][] expected = {
                {3, -1, 0, 1},
                {2, 2, 1, -1},
                {1, -1, 2, -1},
                {0, -1, 3, 4}
        };
        // When
        main.wallsAndGatesDFS(rooms);
        // Then
        assertArrayEquals(expected, rooms);
    }

    @Test
    public void testWallsAndGatesBFS() {
        // Given
        Main main = new Main();
        int[][] rooms = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        int[][] expected = {
                {3, -1, 0, 1},
                {2, 2, 1, -1},
                {1, -1, 2, -1},
                {0, -1, 3, 4}
        };
        // When
        main.wallsAndGatesBFS(rooms);
        // Then
        assertArrayEquals(expected, rooms);
    }

}