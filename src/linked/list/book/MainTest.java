package linked.list.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void insert() {
        // Given
        Main main = new Main();
        // When
        main.insert(0, 1);
        main.insert(1, 2);
        main.insert(2, 3);
        // Then
        assertEquals(1, main.head.data);

    }

    @Test
    void search() {
        // Given
        Main main = new Main();
        main.insert(0, 1);
        main.insert(1, 2);
        main.insert(2, 3);
        // When
        int result = main.search(2);
        // Then
        assertEquals(result, 2);
    }

    @Test
    void delete() {
        // Given
        Main main = new Main();
        main.insert(0, 1);
        main.insert(1, 2);
        main.insert(2, 3);
        // When
        main.delete(0);
        // Then
        assertEquals(2, main.head.data);
    }

    @Test
    void print() {
        // Given
        Main main = new Main();
        main.insert(0, 1);
        main.insert(1, 2);
        main.insert(2, 3);
        // When
        main.print();
        // Then
        assertEquals(1, main.head.data);
    }

    @Test
    void tail() {
        // Given
        Main main = new Main();
        main.insert(0, 1);
        main.insert(1, 2);
        main.insert(2, 3);
        // When
        int result = main.tail();
        // Then
        assertEquals(result, 3);
    }
    @Test
    void reverse() {
        // Given
        Main main = new Main();
        main.insert(0, 1);
        main.insert(1, 2);
        main.insert(2, 3);
        // When
        Main.Node result = main.reverseCopilot();
        // Then
        assertEquals(result.data, 3);
    }


}