package linked.list.top;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListExeTest {

    @Test
    void insert() {
        // Given
        DoublyLinkedList main = new DoublyLinkedList();
        // When
        main.insert(1);
        main.insert(2);
        main.insert(3);
        // Then
        assertEquals(1, main.head.data);
    }

    @Test
    void printReverse() {
        // Given
        DoublyLinkedList main = new DoublyLinkedList();
        main.insert(1);
        main.insert(2);
        main.insert(3);
        // When
        main.printReverse();
        // Then
        assertEquals(3, main.tail.data);
    }

}